package test.java.dbtojson;

import main.java.util.TerminalUtlil;
import org.testng.annotations.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UiGridDocker {
    List<String> dockerId = new ArrayList<String>();

    @BeforeTest
    public void setContainer() throws InterruptedException, IOException {
        TerminalUtlil.runCommand("docker-compose -f docker-compose.yaml up");
    }

    @Test
    public static void test() {

    }

    @AfterTest
    public void Close() throws InterruptedException, IOException {
        TerminalUtlil.runCommand("docker-compose -f docker-compose.yaml down");
    }

}
