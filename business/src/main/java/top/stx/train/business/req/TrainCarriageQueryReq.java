package top.stx.train.business.req;

import top.stx.train.common.req.PageReq;

public class TrainCarriageQueryReq extends PageReq {

	private String trainCode;

	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}

	@Override
	public String toString() {
		return "TrainCarriageQueryReq{" +
				"} " + super.toString();
	}
}
