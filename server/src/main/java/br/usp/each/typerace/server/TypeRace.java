package br.usp.each.typerace.server;

import java.util.*;

public class TypeRace {

    public static List<String> getWordsList(int length) {

        List<String> wordsStock = wordsStock();
        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < length; i++) {

            Random rand = new Random();
            String word = wordsStock().get(rand.nextInt(wordsStock.size()));

            wordsList.add(word);
        }

        return wordsList;
    }

    public static int setPoints(List<String> wordsList, String typedWord, int points, int cont) {

        if (typedWord.equals(wordsList.get(cont)))
            return points++;

        else return points;
    }

    private static List<String> wordsStock() {

        List<String> words = new ArrayList<>();
        
        // 100 palavras em cada linha
        words.add("video"); words.add("close"); words.add("rug"); words.add("rope"); words.add("star"); words.add("scared"); words.add("worried"); words.add("yawning"); words.add("hop"); words.add("parrot"); words.add("singer"); words.add("firefighter"); words.add("driver"); words.add("teeth"); words.add("camel"); words.add("write"); words.add("shelf"); words.add("soccer"); words.add("angry"); words.add("silly"); words.add("crying"); words.add("crocodile"); words.add("kangoroo"); words.add("penguin"); words.add("vet"); words.add("nurse"); words.add("chef"); words.add("feather"); words.add("eat"); words.add("read"); words.add("shower"); words.add("boot"); words.add("bored"); words.add("surprised"); words.add("frowning"); words.add("elephant"); words.add("lion"); words.add("swing"); words.add("artist"); words.add("police"); words.add("dentist"); words.add("trunk"); words.add("kite"); words.add("get"); words.add("stairs"); words.add("cloudy"); words.add("excited"); words.add("thristy"); words.add("laughing"); words.add("giraffe"); words.add("monkey"); words.add("tiger"); words.add("inventor"); words.add("officer"); words.add("doctor"); words.add("claw"); words.add("microwave"); words.add("say"); words.add("stove"); words.add("open"); words.add("hungry"); words.add("tired"); words.add("smiling"); words.add("panda"); words.add("zebra"); words.add("movie"); words.add("scientist"); words.add("farmer"); words.add("tail"); words.add("snake"); words.add("snack"); words.add("love"); words.add("sadness"); words.add("what"); words.add("way"); words.add("friend"); words.add("deep"); words.add("she"); words.add("look"); words.add("here"); words.add("there"); words.add("morning"); words.add("fall"); words.add("felt"); words.add("never"); words.add("missing"); words.add("all"); words.add("life"); words.add("break"); words.add("knee"); words.add("arm"); words.add("hand"); words.add("year"); words.add("2021"); words.add("network"); words.add("coffee"); words.add("energy"); words.add("sun"); words.add("eyes"); words.add("touch");
        words.add("pouring"); words.add("wonder"); words.add("far"); words.add("again"); words.add("count"); words.add("softly"); words.add("show"); words.add("how"); words.add("really"); words.add("meant"); words.add("learn"); words.add("fool"); words.add("found"); words.add("cup"); words.add("gravity"); words.add("sorry"); words.add("superficial"); words.add("how"); words.add("what"); words.add("which"); words.add("therefore"); words.add("thus"); words.add("this"); words.add("there"); words.add("are"); words.add("know"); words.add("where"); words.add("covid"); words.add("sense"); words.add("seattle"); words.add("march"); words.add("april"); words.add("september"); words.add("twenty"); words.add("first"); words.add("night"); words.add("day"); words.add("pass"); words.add("move"); words.add("door"); words.add("lie"); words.add("good"); words.add("blue"); words.add("red"); words.add("yellow"); words.add("green"); words.add("fast"); words.add("slow"); words.add("airplane"); words.add("terminal"); words.add("july"); words.add("still"); words.add("madly"); words.add("crazy"); words.add("use"); words.add("somebody"); words.add("best"); words.add("get"); words.add("back"); words.add("water"); words.add("fire"); words.add("earth"); words.add("need"); words.add("thinking"); words.add("about"); words.add("calling"); words.add("baby"); words.add("top"); words.add("behind"); words.add("under"); words.add("man"); words.add("woman"); words.add("men"); words.add("women"); words.add("gun"); words.add("cash"); words.add("money"); words.add("dollar"); words.add("real"); words.add("win"); words.add("talk"); words.add("loud"); words.add("lost"); words.add("only"); words.add("when"); words.add("crush"); words.add("alive"); words.add("daniel"); words.add("were"); words.add("sunday"); words.add("saturday"); words.add("friday"); words.add("thursday"); words.add("wednesday"); words.add("tuesday"); words.add("monday"); words.add("sunny"); words.add("funny"); words.add("chubby"); words.add("paradise");
        words.add("heart"); words.add("gateway"); words.add("winner"); words.add("takes"); words.add("leave"); words.add("paris"); words.add("tokyo"); words.add("kyoto"); words.add("london"); words.add("madagascar"); words.add("africa"); words.add("brazil"); words.add("argentina"); words.add("korea"); words.add("south"); words.add("north"); words.add("china"); words.add("england"); words.add("holland"); words.add("netherlands"); words.add("france"); words.add("italy"); words.add("portugal"); words.add("spain"); words.add("sweden"); words.add("switzerland"); words.add("thailand"); words.add("japan"); words.add("field"); words.add("black"); words.add("rap"); words.add("blues"); words.add("jazz"); words.add("nocturne"); words.add("head"); words.add("yours"); words.add("mine"); words.add("they"); words.add("care"); words.add("could"); words.add("smile"); words.add("darn"); words.add("dark"); words.add("dream"); words.add("gentle"); words.add("rain"); words.add("indeed"); words.add("search"); words.add("for"); words.add("peace"); words.add("rush"); words.add("push"); words.add("pull"); words.add("language"); words.add("program"); words.add("software"); words.add("hardware"); words.add("computer"); words.add("mobile"); words.add("web"); words.add("code"); words.add("review"); words.add("deploy"); words.add("continuous"); words.add("integration"); words.add("settlement"); words.add("queue"); words.add("notification"); words.add("cloud"); words.add("watch"); words.add("monitor"); words.add("payment"); words.add("trade"); words.add("shadow"); words.add("beauty"); words.add("handsome"); words.add("gentlement"); words.add("young"); words.add("ipanema"); words.add("hope"); words.add("street"); words.add("classical"); words.add("ready"); words.add("went"); words.add("sleep"); words.add("new"); words.add("old"); words.add("one"); words.add("two"); words.add("three"); words.add("alphabet"); words.add("summer"); words.add("spring"); words.add("winter"); words.add("autumn"); words.add("guess"); words.add("hang"); words.add("maybe"); words.add("must"); words.add("have");

        return words;
    }
}