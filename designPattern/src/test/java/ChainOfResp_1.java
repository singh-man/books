import java.io.File;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChainOfResp_1 {

    public static Optional<String> parseText(File file) {
        return Optional.ofNullable(file)
                .filter(f -> f.getName().contains(".txt"))
                .map(f -> "Text file: " + f.getName());
    }

    public static Optional<String> parsePresentation(File file) {
        return Optional.ofNullable(file)
                .filter(f -> f.getName().contains(".ppt"))
                .map(f -> "Presentation file: " + f.getName());
    }

    public static Optional<String> parseAudio(File file) {
        return Optional.ofNullable(file)
                .filter(f -> f.getName().contains(".mp3"))
                .map(f -> "Audio file: " + f.getName());
    }

    public static Optional<String> parseVideo(File file) {
        return Optional.ofNullable(file)
                .filter(f -> f.getName().contains(".mkv"))
                .map(f -> "Video file: " + f.getName());
    }

    public static void main(String[] args) {
        File file = new File("abc.txt", "Dream Theater  - The Astonishing");
        ChainOfResp_1.parseAudio(new File(""));
        Function<File, Optional<String>> parseAudio = ChainOfResp_1::parseAudio;

        System.out.println(
                Stream.<Function<File, Optional<String>>>of(
                                ChainOfResp_1::parseText,
                                ChainOfResp_1::parsePresentation,
                                ChainOfResp_1::parseAudio,
                                f -> ChainOfResp_1.parseVideo(f))
                        .map(f -> f.apply(file))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Unknown file: " + file))
        );
    }

}
