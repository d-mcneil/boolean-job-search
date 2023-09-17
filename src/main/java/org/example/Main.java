package org.example;

public class Main {
    public static final String[] RANKS = Inputs.RANKS;
    public static final String[] LABELS = Inputs.LABELS;
    public static final String[] POSITIONS = Inputs.POSITIONS;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append(addRanksToBooleanSearch());
        sb.append(" AND ");
        sb.append(addLabelsAndPositionsToBooleanSearch());
        System.out.println(sb);
    }

    private static String addRanksToBooleanSearch() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < RANKS.length; i++) {
            sb.append("\"");
            sb.append(RANKS[i]);
            sb.append("\"");
            if (i != RANKS.length - 1) {
                sb.append(" OR ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private static String addLabelsAndPositionsToBooleanSearch() {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < LABELS.length; i++) {
            for (int j = 0; j < POSITIONS.length; j++) {
                sb.append("\"");
                sb.append(LABELS[i]).append(" ").append(POSITIONS[j]);
                sb.append("\"");
                if (
                        i == LABELS.length - 1 &&
                        j == POSITIONS.length - 1
                ) {
                    break;
                }
                    sb.append(" OR ");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}