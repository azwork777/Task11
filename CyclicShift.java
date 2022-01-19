package ru.vsu.cs.zhikhorev_a_a;

public class CyclicShift {
    private static final String RUS_CAPITAL = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String RUS_LOWERCASE = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String ENG_CAPITAL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ENG_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public static String encodeByCyclicShift(String sentence, int shift) {
        String code = "";
        String myStr;
        int index;

        for (int i = 0; i < sentence.length(); i++) {
            if (RUS_CAPITAL.contains(sentence.substring(i, i + 1))) {
                index = RUS_CAPITAL.indexOf(sentence.charAt(i)) + shift;

                if (index >= 33) {
                    index = index - 33;
                }
                myStr = Character.toString(RUS_CAPITAL.charAt(index));
                code += myStr;
            }

            if (RUS_LOWERCASE.contains(sentence.substring(i, i + 1))) {
                index = RUS_LOWERCASE.indexOf(sentence.charAt(i)) + shift;

                if (index >= 33) {
                    index = index - 33;
                }
                myStr = Character.toString(RUS_LOWERCASE.charAt(index));
                code += myStr;
            }

            if (ENG_CAPITAL.contains(sentence.substring(i, i + 1))) {
                index = ENG_CAPITAL.indexOf(sentence.charAt(i)) + shift;

                if (index >= 33) {
                    index = index - 26;
                }
                myStr = Character.toString(ENG_CAPITAL.charAt(index));
                code += myStr;
            }

            if (ENG_LOWERCASE.contains(sentence.substring(i, i + 1))) {
                index = ENG_LOWERCASE.indexOf(sentence.charAt(i)) + shift;

                if (index >= 26) {
                    index = index - 26;
                }
                myStr = Character.toString(ENG_LOWERCASE.charAt(index));
                code += myStr;
            }

            if (!ENG_LOWERCASE.contains(sentence.substring(i, i + 1)) && !ENG_CAPITAL.contains(sentence.substring(i, i + 1)) && !RUS_LOWERCASE.contains(sentence.substring(i, i + 1)) && !RUS_CAPITAL.contains(sentence.substring(i, i + 1))) {
                code += Character.toString(sentence.charAt(i));
            }
        }

        return code;
    }
}
