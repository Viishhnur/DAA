package graph;

public class IPair implements Comparable<IPair> {
    public int first, second;

    // weight, adjNode
    public IPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(IPair other) {
        return this.first - other.first;
    }
}
