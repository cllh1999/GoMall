package com.hao.gomall_core.weChat.templates;

import com.hao.gomall_core.weChat.BaseWXEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {

    }

    @Override
    public void onReq(BaseReq baseReq) {

    }
}
