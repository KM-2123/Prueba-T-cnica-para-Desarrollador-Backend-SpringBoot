package org.maravilla.pruebatecnicasb.services;

import org.maravilla.pruebatecnicasb.dto.PaymentDetailsDTO;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.YearMonth;

@Service
public class PaymentService {
    public boolean processPayment(PaymentDetailsDTO paymentDetailsDTO) {
        return isValidPaymentDetails(paymentDetailsDTO);
    }

    private boolean isValidPaymentDetails(PaymentDetailsDTO paymentDetailsDTO) {
        if (paymentDetailsDTO == null || paymentDetailsDTO.getAmount() <= 0 ||
                !isValidCardNumber(paymentDetailsDTO.getCardNumber()) ||
                paymentDetailsDTO.getCardHolderNumber() == null ||
                paymentDetailsDTO.getCardHolderNumber().isEmpty() ||
                !isValidExpirationDate(paymentDetailsDTO.getExpirationYear(), paymentDetailsDTO.getExpirationMonth()) ||
                !isValidCvv(paymentDetailsDTO.getCvv())) {
            return false;
        }
        return true;
    }

    private boolean isValidCardNumber(String cardNumber) {
        cardNumber = cardNumber.replaceAll("\\s+", "").replaceAll("-", "");
        if (cardNumber.length() != 16) {
            return false;
        }
        int[] digits = new int[16];
        for (int i = 0; i < 16; i++) {
            digits[i] = Character.getNumericValue(cardNumber.charAt(i));
        }
        int sum = 0;
        for (int i = 14; i >= 0; i -= 2) {
            int digit = digits[i];
            digit *= 2;
            if (digit > 9) {
                digit -= 9;
            }
            sum += digit;
        }
        for (int i = 15; i >= 0; i -= 2) {
            sum += digits[i];
        }
        return sum % 10 == 0;
    }

    private boolean isValidExpirationDate(int year, int month) {
        LocalDate currentDate = LocalDate.now();
        YearMonth expirationDate = YearMonth.of(year, month);
        return expirationDate.isAfter(YearMonth.from(currentDate));
    }

    private boolean isValidCvv(String cvv) {
        return cvv != null && cvv.length() == 3;
    }
}
