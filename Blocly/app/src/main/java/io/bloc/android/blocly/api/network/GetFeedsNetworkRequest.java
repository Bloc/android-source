package io.bloc.android.blocly.api.network;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Austin on 11/13/2015.
 */
public class GetFeedsNetworkRequest extends NetworkRequest<List<GetFeedsNetworkRequest.FeedResponse>>{

    private static final String XML_TAG_TITLE = "title";
    private static final String XML_TAG_DESCRIPTION = "description";
    private static final String XML_TAG_LINK = "link";
    private static final String XML_TAG_ITEM = "item";
    private static final String XML_TAG_CONTENT_ENCODED = "content:encoded";
    private static final String XML_TAG_MEDIA_CONTENT = "media:content";
    private static final String XML_TAG_PUB_DATE = "pubDate";
    private static final String XML_TAG_GUID = "guid";
    private static final String XML_TAG_ENCLOSURE = "enclosure";
    private static final String XML_ATTRIBUTE_URL = "url";
    private static final String XML_ATTRIBUTE_TYPE = "type";
    public static final int ERROR_PARSING = 3;

    String [] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls) {
        this.feedUrls = feedUrls;
    }

    @Override
    public List<FeedResponse> performRequest(){
        List<FeedResponse> responseFeeds = new ArrayList<FeedResponse>(feedUrls.length);
        for(String feedUrlString : feedUrls){
            InputStream inputStream = openStream(feedUrlString);
            if(inputStream == null){
                return null;
            }
            try{
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document xmlDocument = documentBuilder.parse(inputStream);
                String channelTitle = optFirstTagFromDocument(xmlDocument, XML_TAG_TITLE);
                String channelDescription = optFirstTagFromDocument(xmlDocument, XML_TAG_DESCRIPTION);
                String channelURL = optFirstTagFromDocument(xmlDocument, XML_ATTRIBUTE_URL);

                NodeList allItemNodes = xmlDocument.getElementsByTagName(XML_TAG_ITEM);
                List<ItemResponse> responseItems = new ArrayList<ItemResponse>(allItemNodes.getLength());
                for(int itemIndex = 0; itemIndex < allItemNodes.getLength(); itemIndex++){
                    String itemURL = null;
                    String itemTitle = null;
                    String itemImageURL = null;
                    String itemDescription = null;
                    String itemContentEncodedText = null;
                    String itemMediaURL = null;
                    String itemMediaMIMEType = null;
                    String itemGUID = null;
                    String itemPubDate = null;
                    String itemEnclosureURL = null;
                    String itemEnclosureMIMEType = null;

                    Node itemNode = allItemNodes.item(itemIndex);
                    NodeList tagNodes = itemNode.getChildNodes();
                    for(int tagIndex = 0; tagIndex < tagNodes.getLength(); tagIndex++) {
                        Node tagNode = tagNodes.item(tagIndex);
                        String tag = tagNode.getNodeName();
                        if (XML_TAG_LINK.equalsIgnoreCase(tag)) {
                            itemURL = tagNode.getTextContent();
                        } else if (XML_TAG_TITLE.equalsIgnoreCase(tag)) {
                            itemTitle = tagNode.getTextContent();
                        } else if (XML_TAG_DESCRIPTION.equalsIgnoreCase(tag)) {
                            itemDescription = tagNode.getTextContent();
                            String descriptionText = tagNode.getTextContent();
                            itemImageURL = parseImageFromHTML(descriptionText);
                            itemDescription = parseTextFromHTML(descriptionText);
                        } else if (XML_TAG_ENCLOSURE.equalsIgnoreCase(tag)) {
                            NamedNodeMap enclosureAttributes = tagNode.getAttributes();
                            itemEnclosureURL = enclosureAttributes.getNamedItem(XML_ATTRIBUTE_URL).getTextContent();
                            itemEnclosureMIMEType = enclosureAttributes.getNamedItem(XML_ATTRIBUTE_TYPE).getTextContent();
                        } else if (XML_TAG_PUB_DATE.equalsIgnoreCase(tag)) {
                            itemPubDate = tagNode.getTextContent();
                        } else if (XML_TAG_GUID.equalsIgnoreCase(tag)) {
                            itemGUID = tagNode.getTextContent();
                        } else if (XML_TAG_CONTENT_ENCODED.equalsIgnoreCase(tag)) {
                            String contentEncoded = tagNode.getTextContent();
                            itemImageURL = parseImageFromHTML(contentEncoded);
                            itemContentEncodedText = parseTextFromHTML(contentEncoded);
                        } else if (XML_TAG_MEDIA_CONTENT.equalsIgnoreCase(tag)) {
                            NamedNodeMap mediaAttributes = tagNode.getAttributes();
                            itemMediaURL = mediaAttributes.getNamedItem(XML_ATTRIBUTE_URL).getTextContent();
                        }
                        if (itemEnclosureURL == null) {
                            itemEnclosureURL = itemImageURL;
                        }

                        if (itemEnclosureURL == null) {
                            itemEnclosureURL = itemMediaURL;
                            itemEnclosureMIMEType = itemMediaMIMEType;
                        }
                        if (itemContentEncodedText != null) {
                            itemDescription = itemContentEncodedText;
                        }
                    }
                    responseItems.add(new ItemResponse(itemURL, itemTitle, itemDescription, itemGUID, itemPubDate, itemEnclosureURL, itemEnclosureMIMEType));
                }
                responseFeeds.add(new FeedResponse(feedUrlString, channelTitle, channelURL, channelDescription, responseItems));
                inputStream.close();
            }catch(IOException e){
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                setErrorCode(ERROR_PARSING);
                return null;
            } catch (SAXException e) {
                e.printStackTrace();
                setErrorCode(ERROR_PARSING);
                return null;
            }
        }
        return responseFeeds;
    }

    private String optFirstTagFromDocument(Document document, String tagName){
        NodeList elementsByTagName = document.getElementsByTagName(tagName);
        if(elementsByTagName.getLength() > 0){
            return elementsByTagName.item(0).getTextContent();
        }
        return null;
    }

    public static class FeedResponse {
        public static String channelFeedURL;
        public static String channelTitle;
        public static String channelURL;
        public static String channelDescription;
        public static List<ItemResponse> channelItems;

        FeedResponse(String channelFeedURL, String channelTitle, String channelURL,
                     String channelDescription, List<ItemResponse> channelItems) {
            this.channelFeedURL = channelFeedURL;
            this.channelTitle = channelTitle;
            this.channelURL = channelURL;
            this.channelDescription = channelDescription;
            this.channelItems = channelItems;
        }

        public String getChannelFeedURL(){
            return channelFeedURL;
        }

        public String getChannelTitle(){
            return channelTitle;
        }

        public String getChannelURL(){
            return channelURL;
        }

        public String getChannelDescription(){
            return channelDescription;
        }

        public List<ItemResponse> getItems(){
            return channelItems;
        }
    }


    public static class ItemResponse {
        public final String itemURL;
        public final String itemTitle;
        public final String itemDescription;
        public final String itemGUID;
        public final String itemPubDate;
        public final String itemEnclosureURL;
        public final String itemEnclosureMIMEType;

        ItemResponse(String itemURL, String itemTitle, String itemDescription,
                     String itemGUID, String itemPubDate, String itemEnclosureURL,
                     String itemEnclosureMIMEType) {
            this.itemURL = itemURL;
            this.itemTitle = itemTitle;
            this.itemDescription = itemDescription;
            this.itemGUID = itemGUID;
            this.itemPubDate = itemPubDate;
            this.itemEnclosureURL = itemEnclosureURL;
            this.itemEnclosureMIMEType = itemEnclosureMIMEType;
        }

        public String getItemURL(){
            return itemURL;
        }

        public String getItemTitle(){
            return itemTitle;
        }

        public String getItemDescription(){
            return itemDescription;
        }

        public String getItemGUID(){
            return itemGUID;
        }

        public String getItemPubDate(){
            return itemPubDate;
        }
    }

    static String parseTextFromHTML(String htmlString){
        org.jsoup.nodes.Document document = Jsoup.parse(htmlString);
        return document.body().text();
    }

    static String parseImageFromHTML(String htmlString){
        org.jsoup.nodes.Document document = Jsoup.parse(htmlString);
        Elements imgElements = document.select("img");
        if(imgElements.isEmpty()){
            return null;
        }
        return imgElements.attr("src");
    }
}
