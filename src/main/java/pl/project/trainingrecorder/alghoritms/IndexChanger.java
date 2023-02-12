package pl.project.trainingrecorder.alghoritms;

public class IndexChanger {
    public int addToIndex(int index, int size) {
        if (index == size) {
            return index;
        } else {
            return index + 1;
        }
    }

    public int minusFromIndex(int index) {
        if (index == 0) {
            return index;
        } else {
            return index - 1;
        }
    }
}
