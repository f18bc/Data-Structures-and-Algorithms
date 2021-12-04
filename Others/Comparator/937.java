class Solution {
    // Time O(M * N * logN), where N is the number of logs and M is the maximum length of a log
    // Space O(M * logN)
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> cpstr = new Comparator<>() {
            @Override
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    if (!split1[1].equals(split2[1])) {
                        return split1[1].compareTo(split2[1]);
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(logs, cpstr);
        return logs;
    }
    /*
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String log1, String log2) {
                String[] split1 = log1.split(" ", 2);
                String[] split2 = log2.split(" ", 2);
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                if (!isDigit1 && !isDigit2) {
                    if (!split1[1].equals(split2[1])) {
                        return split1[1].compareTo(split2[1]);
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                } else if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return logs;
    }
    */
}