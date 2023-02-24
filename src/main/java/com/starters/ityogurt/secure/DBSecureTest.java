package com.starters.ityogurt.secure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBSecureTest {
    public static void main(String[] args) {
        StandardPBEStringEncryptor db = new StandardPBEStringEncryptor();
        db.setPassword("itpaoy20531");
        String driver = db.encrypt("org.mariadb.jdbc.Driver");
        String url = db.encrypt("jdbc:mariadb://it-yogurt-rds.c3ecev1oav62.ap-south-1.rds.amazonaws.com");
        String account = db.encrypt("ityogurt");
        String password = db.encrypt("ityogurt0000$");
        String awsaccesskey = db.encrypt("AKIA2JW73SBWU4BLUHFY");
        String awssecretkey = db.encrypt("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");
        String googleid = db.encrypt("388760205254-7817m1dcfbne3e3kbrkrtt965aeekdk8.apps.googleusercontent.com");
        String googlesecret = db.encrypt("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");
        String kakaoid = db.encrypt("7b1175dff73a2215cfb67a75640efc45");
        String kakaosecret = db.encrypt("0SuEJLorqgL5NN4jCPjmwLJTYhqzD3ml");
        String naverid = db.encrypt("o8o4CPqE24zoipTTKGcb");
        String naverstate = db.encrypt("IT-Yogurt_0214");
        String naversecret = db.encrypt("Dl_mQc6h8S");


    }
}