import java.util.*;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            int idx = log.indexOf(' ');
            char firstChar = log.charAt(idx + 1);
            if (Character.isDigit(firstChar)) {
                digitLogs.add(log);
            } else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, (a, b) -> {
            String id1 = a.substring(0, a.indexOf(" "));
String content1 = a.substring(a.indexOf(" ") + 1);
            String id2 = b.substring(0, b.indexOf(" "));
            String content2 = b.substring(b.indexOf(" ") + 1);

            int cmp = content1.compareTo(content2);
            if (cmp == 0) {
                return id1.compareTo(id2);
            }
            return cmp;
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}
