package test.jsp.tags;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.JspTagException;

public class BodyTagExample extends BodyTagSupport {
    private int counts;

    public BodyTagExample() {
        super();
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }

    @Override
    public int doStartTag() throws JspTagException {
        System.out.println("doStartTag...");
        if (counts > 0) {
            return EVAL_BODY_TAG;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public void setBodyContent(BodyContent bodyContent) {
        System.out.println("setBodyContent...");
        this.bodyContent = bodyContent;
    }

    @Override
    public void doInitBody() throws JspTagException {
        System.out.println("doInitBody....");
    }

    @Override
    public int doAfterBody() throws JspTagException {
        System.out.println("do After body..." + counts);
        if (counts > 1) {
            counts--;
            return EVAL_BODY_TAG;
        } else {
            return SKIP_BODY;
        }
    }

    @Override
    public int doEndTag() throws JspTagException {
        System.out.println("do end Tag...");
        try {
            if (bodyContent != null) {
                bodyContent.writeOut(bodyContent.getEnclosingWriter());
            }
        } catch (java.io.IOException e) {
            throw new JspTagException("IO Error: " + e.getMessage());
        }
        return EVAL_PAGE;
    }
}