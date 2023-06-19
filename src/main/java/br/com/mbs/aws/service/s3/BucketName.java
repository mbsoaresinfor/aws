package br.com.mbs.aws.service.s3;

public enum BucketName {

    MARCELO_TEST_BUCKET_3("marcelo-test-bucket3");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getValue(){
        return bucketName;
    }
}
