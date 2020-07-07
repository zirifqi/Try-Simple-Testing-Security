package id.go.rembangkab.ngetest.models;

public class Resp_signature {
    private boolean result;
    private Integer proses;
    private String title, signature;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Integer getProses() {
        return proses;
    }

    public void setProses(Integer proses) {
        this.proses = proses;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
