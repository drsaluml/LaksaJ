package com.firestack.laksaj.transaction;


import com.firestack.laksaj.blockchain.TransactionReceipt;
import com.firestack.laksaj.jsonrpc.Provider;
import com.firestack.laksaj.utils.ByteUtil;
import com.firestack.laksaj.utils.TransactionUtil;
import lombok.Data;
import lombok.experimental.Builder;

import java.util.Optional;

@Data
@Builder
public class Transaction {
    private String ID;
    private String version;
    private String nonce;
    private String amount;
    private String gasPrice;
    private String gasLimit;
    private String signature;
    private TransactionReceipt receipt;
    private String senderPubKey;
    private String toAddr;
    private String code;
    private String data;

    private Provider provider;
    private TxStatus status;

    public TxParams toTransactionParam() {
        return TxParams.builder()
                .ID(this.ID)
                .version(this.version)
                .nonce(this.nonce)
                .amount(this.amount)
                .gasPrice(this.gasPrice)
                .gasLimit(this.gasLimit)
                .signature(this.signature)
                .receipt(this.receipt)
                .senderPubKey(this.senderPubKey)
                .toAddr(this.toAddr)
                .code(Optional.of(this.code))
                .data(Optional.of(this.data))
                .build();
    }

    public TransactionPayload toTransactionPayload() {
        return TransactionPayload.builder()
                .version(Integer.parseInt(this.version))
                .nonce(Integer.parseInt(this.nonce))
                .toAddr(this.toAddr)
                .amount(this.amount)
                .pubKey(this.senderPubKey)
                .gasPrice(this.gasPrice)
                .gasLimit(this.gasLimit)
                .code(this.code)
                .data(this.data)
                .signature(this.signature)
                .build();
    }

    public byte[] bytes() {
        TxParams txParams = toTransactionParam();
        TransactionUtil util = new TransactionUtil();
        byte[] bytes = util.encodeTransactionProto(txParams);
        System.out.println("encodes is:" + ByteUtil.byteArrayToHexString(bytes));
        return bytes;
    }
}
