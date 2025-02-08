import java.awt.*;

public class VideoStreamingApplication {
    private Database database;
    public int seekTime(String userId, String videoId){
        WatchedVideo watchedVideo = database.getWatchedVideo(userId, videoId);
        return watchedVideo.getSeekTime();
    }
}

class VideoService{
    private FileSystem fileSystem;

    public Frame getFrame(String videoId, int timestamp){
        Video video = fileSystem.getVideo(videoId);
        return video.getFrame(timestamp);
    }
}

class FileSystem{
    public Video getVideo(String videoId){
        return null;
    }
}

class Database{
    public WatchedVideo getWatchedVideo(String userId, String videoId){
       return null;
    }
}

class Video{
    String id;
    Frame[] frames;
    String jsonMetaData;

    public Frame getFrame(int timestamp){
        for (int i = 0; i < frames.length; i++) {
            if(frames[i].timestamp <= timestamp && frames[i].timestamp+Frame.frameTime>timestamp){
                return frames[i];
            }
        }
        throw new IndexOutOfBoundsException();
    }
}

class Frame{
    public static int frameTime = 10;
    byte[] bytes;
    int timestamp;

    int startTimestamp;
    int endTimestamp;

}

class User{
    String id;
    String name;
    String email;

    public String getId(){
        return id;
    }
}

class WatchedVideo{
    String id;
    String videoId;
    String userId;
    int seekTime;

    public int getSeekTime(){
        return seekTime;
    }
}
