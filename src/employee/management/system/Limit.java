package employee.management.system;

import java.awt.*;
        import javax.swing.*;
        import javax.swing.text.*;
class Limit extends PlainDocument {
    private int limit;
    Limit(int limit) {
        super();
        this.limit = limit;
    }
    Limit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}