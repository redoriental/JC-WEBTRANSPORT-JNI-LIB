package top.redoriental.webtransport.server.pojo;


import java.util.HashMap;

public class Request {

    public Request(String remoteAddr,String path,String authority,HashMap headers){
        headers.forEach((k,v)->{
            this.headers.put(k+"",v+"");
        });
        this.authority = authority+"";
        this.path = path+"";
        this.remoteAddr = remoteAddr+"";
    }

    public final String remoteAddr;

    public final String path;

    public final String authority;

    public final HashMap<String,String> headers = new HashMap<>();





}
