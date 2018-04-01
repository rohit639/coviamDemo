package com.imdb.topList.utils;

public class Locators {

	public class BasePage {
		public static final String yourTripsLink = "Your trips";
		public static final String signInButton = "SignIn";
		public static final String clearTripLogo = "cleartripLogo";
	}

	public class LandingPage {
		public static final String hotelLink = "Hotels";
		public static final String oneWay = "OneWay";
		public static final String fromPlace = "FromTag";
		public static final String toPlace = "ToTag";
		public static final String searchButton = "SearchBtn";
	}

	public class HotelBokingPage {
		public static final String localityTextBox = "Tags";
		public static final String searchButton = "SearchHotelsButton";
		public static final String travellerSelection = "travellersOnhome";
		public static final String checkOutDate = "CheckOutDate";
	}

	public class SignInPage {
		public static final String frame = "modal_window";
		public static final String titleValidation = "h1";
		public static final String sigInButton = "signInButton";
		public static final String errorMessage = "errors1";
	}

	public class SearchResultPage {
		public static final String modifySearch = "//div[@id='ResultContainer_1_1']//a[@id='modifySearchLink']";
	}

}
