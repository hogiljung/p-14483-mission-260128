public class Calc {
    public static int run(String exp) {
        if (exp.contains("- ")) {
            exp = exp.replace("- ", "+ -");
        }

        while (exp.contains("(")) {
            int cnt = 1;
            int s = exp.indexOf("(") + 1;
            int e = s;
            while (e < exp.length()) {
                if (exp.charAt(e) == '(') {
                    cnt += 1;
                } else if (exp.charAt(e) == ')') {
                    cnt -= 1;
                }
                if (cnt == 0) {
                    break;
                }
                e++;
            }
            exp = exp.replace(exp.substring(s - 1, e + 1), String.valueOf(run(exp.substring(s, e))));
        }

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        int result = 0;
        if (exp.contains("+")) {
            for (String s : exp.split(" \\+ ")) {
                result += run(s);
            }
        } else if (exp.contains("*")) {
            result = 1;
            for (String s : exp.split(" \\* ")) {
                result *= run(s);
            }
        }
        return result;
    }
}
