package org.easyb.plugin;

import org.easyb.result.Result;

public enum Outcome {
    RUNNING, SUCCESS, FAILURE, PENDING;

    public static Outcome outcomeForResult(Result result) {
        if (result.succeeded()) {
            return SUCCESS;
        } else if (result.pending()) {
            return PENDING;
        } else if (result.failed()) {
            return FAILURE;
        } else {
            throw new RuntimeException("Unknown result status encountered: " + result.status());
        }
    }
}
