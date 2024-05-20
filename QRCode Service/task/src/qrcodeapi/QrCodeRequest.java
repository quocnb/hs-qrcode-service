package qrcodeapi;

import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

interface SizeValidation {}

interface TypeValidation {}

interface DataValidation {}
interface CorrectionValidation {}

@GroupSequence({DataValidation.class, SizeValidation.class, CorrectionValidation.class, TypeValidation.class, QrCodeRequest.class})
public class QrCodeRequest {
    private final static String WRONG_DATA_ERROR_MESSAGE = "Contents cannot be null or blank";
    private final static String WRONG_SIZE_ERROR_MESSAGE = "Image size must be between 150 and 350 pixels";
    private final static String WRONG_TYPE_ERROR_MESSAGE = "Only png, jpeg and gif image types are supported";
    private final static String WRONG_CORRECTION_ERROR_MESSAGE = "Permitted error correction levels are L, M, Q, H";

    @Min(value = 150, message = WRONG_SIZE_ERROR_MESSAGE, groups = SizeValidation.class)
    @Max(value = 350, message = WRONG_SIZE_ERROR_MESSAGE, groups = SizeValidation.class)
    private int size = 250;

    @Pattern(regexp = "(?i)PNG|JPEG|GIF", message = WRONG_TYPE_ERROR_MESSAGE, groups = TypeValidation.class)
    private String type = "png";

    @NotBlank(message = WRONG_DATA_ERROR_MESSAGE, groups = DataValidation.class)
    private String contents;

    @Pattern(regexp = "(?i)L|M|Q|H", message = WRONG_CORRECTION_ERROR_MESSAGE, groups = CorrectionValidation.class)
    private String correction = "L";

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }
}
