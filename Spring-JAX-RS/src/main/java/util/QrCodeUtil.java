package util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public class QrCodeUtil {

    public static String generisiQRCode(String url) throws WriterException, IOException {
        int imageSize = 150;
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE,
                imageSize, imageSize);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "png", bos);
        String image = Base64.getEncoder().encodeToString(bos.toByteArray());
        return image;
    }
}
