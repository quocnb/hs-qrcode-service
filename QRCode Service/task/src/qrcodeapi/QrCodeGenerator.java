package qrcodeapi;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;
import java.util.Map;

public class QrCodeGenerator {
    public static BufferedImage qrCode(String contents, int width, int height, String correctionLevel) {
        ErrorCorrectionLevel errCorrectionLevel = switch (correctionLevel.toLowerCase()) {
            case "l" -> ErrorCorrectionLevel.L;
            case "m" -> ErrorCorrectionLevel.M;
            case "q" -> ErrorCorrectionLevel.Q;
            case "h" -> ErrorCorrectionLevel.H;
            default -> throw new IllegalStateException("Unexpected value: " + correctionLevel.toLowerCase());
        };
        QRCodeWriter writer = new QRCodeWriter();
        Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, errCorrectionLevel);
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            return bufferedImage;
        } catch (WriterException e) {
            // handle the WriterException
        }
        return null;
    }
}
