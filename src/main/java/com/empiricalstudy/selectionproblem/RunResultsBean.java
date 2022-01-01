package com.empiricalstudy.selectionproblem;

public class RunResultsBean {
    private long dataMoveCount;
    private long dataCompereCount;
    private long msTime;
    private String algoName;
    private int elementAtSelectedRank;

    public RunResultsBean(long dataMoveCount, long dataCompereCount, long msTime, String algoName, int elementAtSelectedRank) {
        this.dataMoveCount = dataMoveCount;
        this.dataCompereCount = dataCompereCount;
        this.msTime = msTime;
        this.algoName = algoName;
        this.elementAtSelectedRank = elementAtSelectedRank;
    }

    public long getDataMoveCount() {
        return dataMoveCount;
    }

    public long getDataCompereCount() {
        return dataCompereCount;
    }

    public long getMsTime() {
        return msTime;
    }

    public String getAlgoName() {
        return algoName;
    }

    public int getElementAtSelectedRank() {
        return elementAtSelectedRank;
    }

    @Override
    public String toString() {
        return "RunResultsBean{" +
                "dataMoveCount=" + dataMoveCount +
                ", dataCompereCount=" + dataCompereCount +
                ", msTime=" + msTime +
                ", algoName='" + algoName + '\'' +
                ", elementAtSelectedRank=" + elementAtSelectedRank +
                '}';
    }
}
