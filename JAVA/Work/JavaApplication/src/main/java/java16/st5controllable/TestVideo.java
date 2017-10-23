package java16.st5controllable;

public class TestVideo {
    
    public static void main(String[] args) {
        VideoPlayer vp = new VideoPlayer() {
            
            public void play() {
                System.out.println("play()");
            }

            public void stop() {
                System.out.println("stop()");
            }
            
        };
        vp.play();
        vp.stop();
    }
    
}
