package io.bloc.android.blocly.api.network;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import io.bloc.android.blocly.api.model.RssItem;

/**
 * Created by ReneeCS on 4/13/15.
 */

public class GetFeedsNetworkRequest extends NetworkRequest<ArrayList<RssItem>> {

    public static final int ERROR_PARSING = 3;

    private static final String XML_TAG_TITLE = "title";
    private static final String XML_TAG_DESCRIPTION = "description";
    private static final String XML_TAG_LINK = "link";
    private static final String XML_TAG_ITEM = "item";
    private static final String XML_TAG_PUB_DATE = "pubDate";
    private static final String XML_TAG_GUID = "guid";
    private static final String XML_TAG_ENCLOSURE = "enclosure";
    private static final String XML_ATTRIBUTE_URL = "url";
    private static final String XML_ATTRIBUTE_TYPE = "type";


    String[] feedUrls;

    public GetFeedsNetworkRequest(String... feedUrls) {
        this.feedUrls = feedUrls;
    }

    @Override
    public ArrayList<RssItem> performRequest() {
        ArrayList<RssItem> responseFeeds = new ArrayList<>(feedUrls.length);
        for (String feedUrlString : feedUrls) {
            InputStream inputStream = openStream(feedUrlString);
            if (inputStream == null) {
                return null;
            }
            try {
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document xmlDocument = documentBuilder.parse(inputStream);

                String channelTitle = optFirstTagFromDocument(xmlDocument, XML_TAG_TITLE);
                String channelDescription = optFirstTagFromDocument(xmlDocument, XML_TAG_DESCRIPTION);
                String channelURL = optFirstTagFromDocument(xmlDocument, XML_TAG_LINK);

                NodeList allItemNodes = xmlDocument.getElementsByTagName(XML_TAG_ITEM);
                List<ItemResponse> responseItems = new ArrayList<ItemResponse>(allItemNodes.getLength());
                    for (int itemIndex = 0; itemIndex < allItemNodes.getLength(); itemIndex++) {
                        String itemURL = null;
                        String itemTitle = null;
                        String itemDescription = null;
                        String itemGUID = null;
                        String itemPubDate = null;
                        String itemEnclosureURL = null;
                        String itemEnclosureMIMEType = null;

                        Node itemNode = allItemNodes.item(itemIndex);
                        NodeList tagNodes = itemNode.getChildNodes();
                        for (int tagIndex = 0; tagIndex < tagNodes.getLength(); tagIndex++) {
                            Node tagNode = tagNodes.item(tagIndex);
                            String tag = tagNode.getNodeName();
                            if (XML_TAG_LINK.equalsIgnoreCase(tag)) {
                                itemURL = tagNode.getTextContent();
                            } else if (XML_TAG_TITLE.equalsIgnoreCase(tag)) {
                                itemTitle = tagNode.getTextContent();
                            } else if (XML_TAG_DESCRIPTION.equalsIgnoreCase(tag)) {
                                itemDescription = tagNode.getTextContent();
                            } else if (XML_TAG_ENCLOSURE.equalsIgnoreCase(tag)) {
                                NamedNodeMap enclosureAttributes = tagNode.getAttributes();
                                itemEnclosureURL = enclosureAttributes.getNamedItem(XML_ATTRIBUTE_URL).getTextContent();
                                itemEnclosureMIMEType = enclosureAttributes.getNamedItem(XML_ATTRIBUTE_TYPE).getTextContent();
                            } else if (XML_TAG_PUB_DATE.equalsIgnoreCase(tag)) {
                                itemPubDate = tagNode.getTextContent();
                            } else if (XML_TAG_GUID.equalsIgnoreCase(tag)) {
                                itemGUID = tagNode.getTextContent();
                            }
                        }
                        responseItems.add(new ItemResponse(itemURL, itemTitle, itemDescription,
                                itemGUID, itemPubDate, itemEnclosureURL, itemEnclosureMIMEType));
                    }

                for (ItemResponse response: responseItems) {

                    SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss z", Locale.ENGLISH);
                    Date date = format.parse(response.itemPubDate);

                    // date format matches 27 Apr 2015 20:17:41 GMT
                    // For reference - RssItem(String guid, String title, String description, String url, String imageUrl, long rssFeedId, long datePublished, boolean read, boolean favorite, boolean archived)

                    responseFeeds.add(new RssItem(response.itemGUID, response.itemTitle, response.itemDescription, response.itemURL, response.itemEnclosureURL,
                           00, date.getTime(), false, false, false));

                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                setErrorCode(ERROR_IO);
                return null;
            } catch (SAXException e) {
                e.printStackTrace();
                setErrorCode(ERROR_PARSING);
                return null;
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
                setErrorCode(ERROR_PARSING);
                return null;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return responseFeeds;
    }

        private String optFirstTagFromDocument (Document document, String tagName){
            NodeList elementsByTagName = document.getElementsByTagName(tagName);
            if (elementsByTagName.getLength() > 0) {
                return elementsByTagName.item(0).getTextContent();
            }
            return null;
        }

        public static class FeedResponse {
            public final String channelFeedURL;
            public final String channelTitle;
            public final String channelURL;
            public final String channelDescription;
            public final List<ItemResponse> channelItems;

            FeedResponse(String channelFeedURL, String channelTitle, String channelURL,
                         String channelDescription, List<ItemResponse> channelItems) {
                this.channelFeedURL = channelFeedURL;
                this.channelTitle = channelTitle;
                this.channelURL = channelURL;
                this.channelDescription = channelDescription;
                this.channelItems = channelItems;
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

            public RssItem toFeedItem () throws ParseException {

                SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss z", Locale.ENGLISH);
                Date date = format.parse(this.itemPubDate);

                RssItem feedItem = new RssItem(this.itemGUID, this.itemTitle, this.itemDescription, this.itemURL, "", 00, date.getTime(), false, false, false);

                return feedItem;
            };

        }

}