package view;

public enum PaymentOption {
    CARD,
    CASH;

    public static PaymentOption from(final String input) {
        try {
            final int selection = Integer.parseInt(input);
            if (selection == 1) {
                return CASH;
            }
            if (selection == 2) {
                return CARD;
            }

            throw new IllegalArgumentException("존재하지 않는 옵션입니다.");
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}
