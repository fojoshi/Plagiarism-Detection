package sheetal;

import com.google.gson.Gson;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Plagiarism extends javax.swing.JFrame {

    String s1 = "";
    int totalcount = 0, count = 0, b;
    /**
     * String Pattern *
     */
    private String pat;
    /**
     * pattern hash value *
     */
    private long patHash;
    /**
     * pattern length *
     */
    private int M;
    /**
     * Large prime *
     */
    private long Q;
    /**
     * radix *
     */
    private int R;
    /**
     * R^(M-1) % Q *
     */
    private long RM;

    /**
     * Constructor
     *
     * @param txt *
     */
    private static final String FILE_NAME = "C:\\Users\\rasik\\Favorites\\Desktop\\s\\temp.txt";
    String strg;
    private static Pattern patternDomainName;
    private Matcher matcher;
    private static final String DOMAIN_NAME_PATTERN
            = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";

    static {
        patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
    }

    public Plagiarism() {

        initComponents();
        getContentPane().setBackground(new Color(204, 204, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        browse = new javax.swing.JButton();
        filelabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        startanalysis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plagiarism Detector");
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("Upload file:");
        jLabel1.setToolTipText("");

        browse.setText("Browse");
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        filelabel.setText("(pdf  or text files upto 500MB)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(browse)
                        .addGap(18, 18, 18)
                        .addComponent(filelabel)))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(browse)
                    .addComponent(filelabel))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Upload file");

        jLabel2.setText("OR");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel3.setText("Enter text:");

        txt1.setColumns(20);
        txt1.setLineWrap(true);
        txt1.setRows(5);
        jScrollPane1.setViewportView(txt1);

        jLabel5.setText("Maximum 1000 words");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel5))
        );

        startanalysis.setText("Start Analysis");
        startanalysis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startanalysisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(startanalysis)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startanalysis)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {                                       
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("DOC & TXT Images", "doc", "txt");
        chooser.setFileFilter(filter);
        String filename;
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println((filename = chooser.getSelectedFile().getName()) + " is opened");
            try {
                File f = chooser.getSelectedFile();
                System.out.println("file=" + f);
                FileReader fr = new FileReader(f);
                BufferedReader b = new BufferedReader(fr);
                String t = "", tempread = "";
                int c = 0;
                while ((t = b.readLine()) != null && c != 100) {

                    tempread += t;
                    c++;

                }
                System.out.println("length of text=" + c);
                //System.err.println("tempread" + tempread);
                txt1.setText(tempread);
                System.out.println("File content is:\n" + txt1.getText());
                filelabel.setText(filename + " uploaded");
                System.out.println("length=" + tempread.length());
            } catch (IOException ex) {
                Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }                                      

    private void startanalysisActionPerformed(java.awt.event.ActionEvent evt) {                                              
        //start search
        strg = txt1.getText();

        File patternfile = new File("C:\\Users\\rasik\\Favorites\\Desktop\\s\\pattern.txt");
        try {
            FileWriter writehtmlfree1 = new FileWriter(patternfile);
        } catch (IOException ex) {
            Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (FileWriter writer = new FileWriter(patternfile)) {

            writer.write(strg);
        } catch (IOException ex) {
            Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
        }

        Plagiarism obj = new Plagiarism();

        try {
            String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";

            String query = getPlainText();
            String charset = "UTF-8";

            URL url = new URL(address + URLEncoder.encode(query, charset));
            Reader reader = new InputStreamReader(url.openStream(), charset);
            GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
            int total = results.getResponseData().getResults().size();
            //System.out.println("total: "+total);
            File htmlfreefile = new File("C:\\Users\\rasik\\Favorites\\Desktop\\s\\HtmlFreeText.txt");
            htmlfreefile.createNewFile();

            // Show title and URL of each results
            try {
                for (int i = 0; i <= 3/*total-1*/; i++) {
                    System.out.println("Iteration number@@@@@@@  " + (i + 1) + "  Starts here.........................");
                    totalcount = 0;
                    count = 0;
                    String t = "";
                    System.out.println("Title: " + results.getResponseData().getResults().get(i).getTitle());
                    System.out.println("URL: " + (t = results.getResponseData().getResults().get(i).getUrl() + "\n"));
                    File file = new File("C:\\Users\\rasik\\Favorites\\Desktop\\s\\temp.txt");
                    file.createNewFile();
                    String bodytext = "";
                    try (FileWriter writer = new FileWriter(file)) {
                        writer.write("");
                        writer.write(t + System.lineSeparator());
                        URL urlnew = new URL(t);
                        URLConnection urlcon = urlnew.openConnection();
                        //System.out.println("URLConnection executed");
                        Document doc = Jsoup.connect(t).get();
                        //System.out.println("Document executed");
                        bodytext = doc.body().text();
                        //System.out.println("body Text=" + bodytext);
                        getURLContent(t);
                        FileWriter writehtmlfree = new FileWriter(htmlfreefile);
                        writehtmlfree.flush();
                        writehtmlfree.write(bodytext);
                        s1 = bodytext;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        RabinKarp rk = new RabinKarp();
                    } catch (IOException e) {
                        System.out.println("No RabinKarp............");
                    }

                    try {
                        System.out.println("\n\n\nHence percentage of plagiarised data for iteration " + (i + 1) + " is:" + (((count) * 100) / (totalcount)) + "%");
                    } catch (ArithmeticException aae) {
                        System.out.println("\n\n\nHence percentage of plagiarised data for iteration " + (i + 1) + " is:" + "(((" + (count - 1) + ") * 100) / (" + (totalcount - 1) + ")) " + "%");

                    }
                    System.out.println("Iteration number@@@@@@@  " + (i + 1) + "  ends here.........................\n");

                }

            } catch (MalformedURLException ex) {
                Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
            }
            //}end while(true)

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Plagiarism.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                             

    private Set<String> getDataFromGoogle(String query) {

        Set<String> result = new HashSet<String>();
        String request = "http://www.google.com/search?q=" + query + "&num=20";
        System.out.println("Sending request..." + request);

        try {

            // need http protocol, set this as a Google bot agent :)
            Document doc = Jsoup
                    .connect(request)
                    .userAgent(
                            "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                    .timeout(5000).get();

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String temp = link.attr("href");
                if (temp.startsWith("/url?q=")) {
                    //use regex to get domain name
                    result.add(getDomainName(temp));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getDomainName(String url) {

        String domainName = "";
        matcher = patternDomainName.matcher(url);
        if (matcher.find()) {
            domainName = matcher.group(0).toLowerCase().trim();
        }
        return domainName;

    }

    public void getURLContent(String u) {

        URL url;
        FileWriter fwtxt = null;
        try {
            // get URL content
            url = new URL(u);
            URLConnection conn = url.openConnection();

            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            StringBuffer sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
            String result = sb.toString();

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            BufferedReader b = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String inputLine, inputLinetxt = null;

            //save to this filename
            String fileName = "C:\\Users\\rasik\\Favorites\\Desktop\\s\\test.html";
            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            String fileNameTxt = "C:\\Users\\rasik\\Favorites\\Desktop\\s\\test.txt";
            File filetxt = new File(fileNameTxt);

            if (!filetxt.exists()) {
                filetxt.createNewFile();
            }

            //use FileWriter to write file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
            }

            fwtxt = new FileWriter(filetxt);

            fwtxt.write(result);

            bw.close();
            br.close();
            fwtxt.close();
            b.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
    }

    public static String readFirstLine(String fileName) throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(fileName))) {
            String x = r.readLine();
            System.out.println("link is" + x);
            return x;
        }
    }

    public String getPlainText() {
        String s = txt1.getText();
        return s;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Plagiarism.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Plagiarism.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Plagiarism.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Plagiarism.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Plagiarism().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton browse;
    private javax.swing.JLabel filelabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton startanalysis;
    private javax.swing.JTextArea txt1;
    // End of variables declaration                   

    class GoogleResults {

        private ResponseData responseData;

        public ResponseData getResponseData() {
            return responseData;
        }

        public void setResponseData(ResponseData responseData) {
            this.responseData = responseData;
        }

        public String toString() {
            return "ResponseData[" + responseData + "]";
        }

        class ResponseData {

            private List<Result> results;

            public List<Result> getResults() {
                return results;
            }

            public void setResults(List<Result> results) {
                this.results = results;
            }

            public String toString() {
                return "Results[" + results + "]";
            }
        }

        class Result {

            private String url;
            private String title;

            public String getUrl() {
                return url;
            }

            public String getTitle() {
                return title;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String toString() {
                return "Result[url:" + url + ",title:" + title + "]";
            }
        }
    }

    class RabinKarp {

        private String pat;

        public RabinKarp(String txt, String pat) {
            this.pat = pat;
            R = 256;

            if (b == 1) {
                b = 1;
            } else {
                b = 0;
            }
            M = pat.length();
            Q = longRandomPrime();
            RM = 1;
            for (int i = 1; i <= M - 1; i++) {
                RM = (R * RM) % Q;
            }
            patHash = hash(pat, M);
            int pos = search(txt);
            if (pos == -1) {
                System.out.println("\nUnique.............\n");
                if (b == 1) {
                    b = 1;
                }
                totalcount++;
            } else {
                //System.out.println("Pattern found at position : " + pos + " Therefore data is plagiarised");
                System.out.println("Plagiarised--------------");
                b = 1;
                count++;
                totalcount++;
            }
        }

        private long hash(String key, int M) {
            long h = 0;
            for (int j = 0; j < M; j++) {
                h = (R * h + key.charAt(j)) % Q;
            }
            return h;
        }

        private boolean check(String txt, int i) {
            for (int j = 0; j < M; j++) {
                if ((pat.charAt(j) != txt.charAt(i + j))) {
                    System.out.println("False");
                    return false;
                }
            }
            return true;
        }

        /**
         * Funtion to check for exact match*
         */
        private int search(String txt) {//txt=null
            int N = txt.length();//length of s1 i.e. htmlfreetext
            if (N < M) {
                return N;
            }
            long txtHash = hash(txt, M);
            /**
             * check for match at start *
             */
            if ((patHash == txtHash) && check(txt, 0)) {
                return 0;
            }
            /**
             * check for hash match. if hash match then check for exact match*
             */
            for (int i = M; i < N; i++) {
                // Remove leading digit, add trailing digit, check for match. 
                txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
                txtHash = (txtHash * R + txt.charAt(i)) % Q;
                // match
                int offset = i - M + 1;
                if ((patHash == txtHash) && check(txt, offset)) {
                    return offset;
                }
            }
            return -1;
        }

        private long longRandomPrime() {
            BigInteger prime = BigInteger.probablePrime(31, new Random());
            return prime.longValue();
        }

        public RabinKarp() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            countLines();
            String line, s3 = "";
            s1 = "";
            try (BufferedReader readers1 = new BufferedReader(new FileReader("C:\\Users\\rasik\\Favorites\\Desktop\\s\\HtmlFreeText.txt"))) {
                line = null;
                while (true) {
                    s1 = "";
                    line = readers1.readLine();
                    if (line == null) {
                        break;
                    }

                    s1 += line;//htmlfreetext
                    s3 = s1;
                }
                readers1.close();
            }
            String line1 = null, s2 = "";
            BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\rasik\\Favorites\\Desktop\\s\\pattern.txt"));
            while (true) {
                s2 = "";
                line1 = reader1.readLine();
                if (line1 == null) {
                    break;
                }

                s2 += line1;//patterntext
                RabinKarp rk;
                System.out.println("Patterntext:\n" + s2 + "\n");

                rk = new RabinKarp(s3, s2);

            }
            reader1.close();
        }

        public void countLines() throws IOException {

            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> list1 = new ArrayList<>();

            // Add all lines from file to ArrayList.
            try ( // New BufferedReader.
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\rasik\\Favorites\\Desktop\\s\\HtmlFreeText.txt"))) {
                // Add all lines from file to ArrayList.
                String line;
                list.removeAll(Collections.singleton(null));
                list1.removeAll(Collections.singleton(null));

                while (true) {
                    b++;
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    list.add(line);
                }
                // Close it.
            }

            try ( // New BufferedReader.
                    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\rasik\\Favorites\\Desktop\\s\\pattern.txt"))) {
                // Add all lines from file to ArrayList.
                while (true) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    list1.add(line);
                }

                // Close it.
            }

        }
    }
}
