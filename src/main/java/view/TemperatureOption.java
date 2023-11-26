package view;

public enum TemperatureOption {
    ICE,
    HOT;

    public static TemperatureOption from(final String input) {
        try {
            final int selection = Integer.parseInt(input);
            if (selection == 1) {
                return ICE;
            }
            if (selection == 2) {
                return HOT;
            }

            throw new IllegalArgumentException("존재하지 않는 옵션입니다.");
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
