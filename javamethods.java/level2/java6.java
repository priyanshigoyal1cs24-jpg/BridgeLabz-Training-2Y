class java6 {
    public static double convertFahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double convertPoundsToKg(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKgToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("100 F = " + convertFahrenheitToCelsius(100) + " °C");
        System.out.println("37 °C = " + convertCelsiusToFahrenheit(37) + " °F");
        System.out.println("150 lb = " + convertPoundsToKg(150) + " kg");
        System.out.println("70 kg = " + convertKgToPounds(70) + " lb");
        System.out.println("10 gallons = " + convertGallonsToLiters(10) + " liters");
        System.out.println("25 liters = " + convertLitersToGallons(25) + " gallons");
    }
}
