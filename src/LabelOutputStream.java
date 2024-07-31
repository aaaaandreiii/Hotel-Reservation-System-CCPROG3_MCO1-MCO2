import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class LabelOutputStream extends OutputStream {
    private final JLabel label;
    private final StringBuilder stringBuilder = new StringBuilder();

    public LabelOutputStream(JLabel label) {
        this.label = label;
    }

    @Override
    public void write(int b) throws IOException {
        if (b == '\n') {
            label.setText(stringBuilder.toString());
            stringBuilder.setLength(0); // clear the buffer
        } else {
            stringBuilder.append((char) b);
        }
    }
}