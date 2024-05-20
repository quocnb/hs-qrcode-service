package qrcodeapi;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@Validated
public class RequestController {
    @GetMapping(path="/api/health")
    @ResponseStatus(HttpStatus.OK)
    public void getHealth() {
    }

    @GetMapping(path="/api/qrcode")
    public ResponseEntity<BufferedImage> getQrCode(@Valid QrCodeRequest request) {
        BufferedImage bufferedImage = QrCodeGenerator.qrCode(request.getContents(), request.getSize(), request.getSize(), request.getCorrection());
        MediaType mediaType = switch (request.getType().toLowerCase()) {
            case "png" -> MediaType.IMAGE_PNG;
            case "jpeg" -> MediaType.IMAGE_JPEG;
            case "gif" -> MediaType.IMAGE_GIF;
            default -> throw new IllegalStateException("Unexpected value: " + request.getType().toLowerCase());
        };
        return ResponseEntity
                .ok()
                .contentType(mediaType)
                .body(bufferedImage);
    }
}
