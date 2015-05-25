package com.bloc.objects;

import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

public class Main extends Object {

		/************************************************
	 	 *	DO NOT MODIFY THIS FILE
		/************************************************/

	public static void main(String [] args) {
		Artist kurtCobain = null;
		Artist daveGrohl = null;
		Artist kristNovoselic = null;
		Artist jasonEverman = null;
		Constructor<?> artistConstructor = getConstructor(Artist.class, String.class, String.class);
		try {
			Artist bonJovi = (Artist) artistConstructor.newInstance("Bon", "Jovi");
			if ("Bon".equals(bonJovi.mFirstName) == false || "Jovi".equals(bonJovi.mLastName) == false) {
				System.out.println("Your Artist constructor failed to assign either the first, last or both names");
				System.exit(1);
			}
			kurtCobain = (Artist) artistConstructor.newInstance("Kurt", "Cobain");
			daveGrohl = (Artist) artistConstructor.newInstance("Dave", "Grohl");
			kristNovoselic = (Artist) artistConstructor.newInstance("Krist", "Novoselic");
			jasonEverman = (Artist) artistConstructor.newInstance("Jason", "Everman");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		// Make some ensembles
		Ensemble nirvana = null;
		Constructor<?> ensembleConstructor1 = getConstructor(Ensemble.class, Artist[].class);
		Constructor<?> ensembleConstructor2 = getConstructor(Ensemble.class, String.class, Artist[].class);
		try {
			nirvana = (Ensemble) ensembleConstructor1.newInstance((Object) new Artist[] {kurtCobain, daveGrohl, kristNovoselic, jasonEverman});
			if (nirvana.mArtists[0] == null || nirvana.mArtists[0] != kurtCobain) {
				System.out.println("Your first Ensemble constructor failed to assign the artists");
				System.exit(1);
			}
			if (nirvana.mName == null || !nirvana.mName.startsWith(kurtCobain.mFirstName)) {
				System.out.println("Your first Ensemble constructor failed to create a name for the Ensemble (expected: 'Kurt Cobain')");
				System.exit(1);	
			}
			nirvana = (Ensemble) ensembleConstructor2.newInstance("Nirvana", (Object) new Artist[] {kurtCobain, daveGrohl, kristNovoselic, jasonEverman});
			if ("Nirvana".equals(nirvana.mName) == false) {
				System.out.println("Your second Ensemble constructor failed to assign the name (expected: 'Nirvana')");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		// Let's write some songs
		Song defaultSong = null;
		Song smellsLikeTeenSpirit = null;
		Constructor songConstructor1 = getConstructor(Song.class, new Class<?>[0]);
		Constructor songConstructor2 = getConstructor(Song.class, Ensemble.class, String.class);
		Constructor songConstructor3 = getConstructor(Song.class, Ensemble.class, String.class, int.class);
		try {
			defaultSong = (Song) songConstructor1.newInstance(new Object[0]);
			if (defaultSong.mEnsemble == null || defaultSong.mTitle == null) {
				System.out.println("Your default Song constructor sets no defaults");
				System.exit(1);
			}
			smellsLikeTeenSpirit = (Song) songConstructor2.newInstance(nirvana, "Smells Like Teen Spirit");
			if (smellsLikeTeenSpirit.mEnsemble != nirvana || "Smells Like Teen Spirit".equals(smellsLikeTeenSpirit.mTitle) == false) {
				System.out.println("Your partial Song constructor failed to set the ensemble, title or both");
				System.exit(1);
			}

			smellsLikeTeenSpirit = (Song) songConstructor3.newInstance(nirvana, "Smells Like Teen Spirit", 1991);
			if (smellsLikeTeenSpirit.mYearReleased != 1991) {
				System.out.println("Your full Song constructor failed to set the release year");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

		// PopSongs!
		Constructor popSong1 = getConstructor(PopSong.class, new Class<?>[0]);
		Constructor popSong2 = getConstructor(PopSong.class, Ensemble.class, String.class);
		Constructor popSong3 = getConstructor(PopSong.class, Ensemble.class, String.class, int.class);
		Constructor popSong4 = getConstructor(PopSong.class, Ensemble.class, String.class, int.class, int.class);
		try {
			PopSong notAPopSong = (PopSong) popSong4.newInstance(nirvana, "Smells Like Teen Spirit", 1991, 82);
			if (notAPopSong.mWeeksOnBillboard != 82) {
				System.out.println("Your full PopSong constructor failed to set the number of weeks on billboard");
				System.exit(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}


		System.out.println("/************************/");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/* Nice work, you pass! */");
		System.out.println("/*                      */");
		System.out.println("/*                      */");
		System.out.println("/************************/\n");
	}

	private static Constructor<?> getConstructor(Class<?> cls, Class<?>... parameterTypes) {
		try {
			return cls.getDeclaredConstructor(parameterTypes);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Missing or incorrect constructor in " + cls.getName());
			System.exit(1);
		}
		return null;
	}
}
