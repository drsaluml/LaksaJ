package com.firestack.laksaj.jsonrpc;

import com.firestack.laksaj.blockchain.*;
import com.firestack.laksaj.exception.ZilliqaAPIException;
import com.firestack.laksaj.transaction.Transaction;
import com.firestack.laksaj.transaction.TransactionPayload;
import com.firestack.laksaj.utils.Bech32;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class HttpProvider {

    private OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private String url;

    public HttpProvider(String url) {
        this.url = url;
    }

    public HttpProvider(String url, OkHttpClient client) {
        this.url = url;
        this.client = client;
    }

    //Blockchain-related methods
    public Rep<String> getNetworkId() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNetworkId").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<BlockchainInfo> getBlockchainInfo() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetBlockchainInfo").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<BlockchainInfo>>() {
        }.getType();
        Rep<BlockchainInfo> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<ShardingStructure> getShardingStructure() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetShardingStructure").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<ShardingStructure>>() {
        }.getType();
        Rep<ShardingStructure> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;

    }

    public Rep<BlockList> getDSBlockListing(int pageNumber) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("DSBlockListing").params(new Integer[]{pageNumber}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<BlockList>>() {
        }.getType();
        Rep<BlockList> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<BlockList> getTxBlockListing(int pageNumber) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("TxBlockListing").params(new Integer[]{pageNumber}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<BlockList>>() {
        }.getType();
        Rep<BlockList> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getNumDSBlocks() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNumDSBlocks").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<Double> getDSBlockRate() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetDSBlockRate").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Double>>() {
        }.getType();
        Rep<Double> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<BlockList> getDSBlockListing() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("DSBlockListing").params(new Object[]{1}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<BlockList>>() {
        }.getType();
        Rep<BlockList> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<DsBlock> getDsBlock(String blockNumber) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetDsBlock").params(new String[]{blockNumber}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<DsBlock>>() {
        }.getType();
        Rep<DsBlock> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<TxBlock> getTxBlock(String blockNumber) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetTxBlock").params(new String[]{blockNumber}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Rep<TxBlock> rep = gson.fromJson(resultString, new TypeToken<Rep<TxBlock>>() {
        }.getType());
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getNumTxBlocks() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNumTxBlocks").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<Double> getTxBlockRate() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetTxBlockRate").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Double>>() {
        }.getType();
        Rep<Double> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<DsBlock> getLatestDsBlock() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetLatestDsBlock").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Rep<DsBlock> rep = gson.fromJson(resultString, new TypeToken<Rep<DsBlock>>() {
        }.getType());
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<TxBlock> getLatestTxBlock() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetLatestTxBlock").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Rep<TxBlock> rep = gson.fromJson(resultString, new TypeToken<Rep<TxBlock>>() {
        }.getType());
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getNumTransactions() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNumTransactions").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<Integer> getTransactionRate() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetTransactionRate").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Integer>>() {
        }.getType();
        Rep<Integer> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getCurrentMiniEpoch() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetCurrentMiniEpoch").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getCurrentDSEpoch() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetCurrentDSEpoch").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<Integer> getPrevDifficulty() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetPrevDifficulty").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Integer>>() {
        }.getType();
        Rep<Integer> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<Integer> getPrevDSDifficulty() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetPrevDSDifficulty").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Integer>>() {
        }.getType();
        Rep<Integer> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    //Account-related methods
    public Rep<BalanceResult> getBalance(String address) throws IOException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetBalance").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<BalanceResult>>() {
        }.getType();
        Rep<BalanceResult> rep = gson.fromJson(resultString, type);

//        Assert.assertNotNull("result is null, check your account address!", rep.getResult());
        if (null == rep.getResult()) {
            BalanceResult balanceResult = new BalanceResult();
            balanceResult.setBalance("0");
            balanceResult.setNonce("0");
            rep.setResult(balanceResult);
        }
        return rep;
    }

    public Rep<BalanceResult> getBalance32(String address) throws Exception {
        return getBalance(Bech32.fromBech32Address(address));
    }

    //Contract-related methods todo need test
    public Rep<ContractResult> getSmartContractCode(String address) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetSmartContractCode").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<ContractResult>>() {
        }.getType();
        Rep<ContractResult> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<List<Contract>> getSmartContracts(String address) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetSmartContracts").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<List<Contract>>>() {
        }.getType();
        Rep<List<Contract>> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getContractAddressFromTransactionID(String address) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetContractAddressFromTransactionID").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<List<Contract.State>> getSmartContractState(String address) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetSmartContractState").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<List<Contract.State>>>() {
        }.getType();
        Rep<List<Contract.State>> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<List<Contract.State>> getSmartContractInit(String address) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetSmartContractInit").params(new String[]{address}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<List<Contract.State>>>() {
        }.getType();
        Rep<List<Contract.State>> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    //Transaction-related methods
    public Rep<CreateTxResult> createTransaction(TransactionPayload payload) throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("CreateTransaction").params(new Object[]{payload}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<CreateTxResult>>() {
        }.getType();
        Rep<CreateTxResult> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getMinimumGasPrice() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetMinimumGasPrice").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }


    public Rep<Transaction> getTransaction(String hash) throws IOException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetTransaction").params(new String[]{hash}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<Transaction>>() {
        }.getType();
        Rep<Transaction> rep = gson.fromJson(resultString, type);
        if (rep.getResult() == null) {
            throw new IOException("get result error = " + resultString);
        }
        return rep;
    }

    public Rep<Transaction> getTransaction32(String hash) throws Exception {
        Rep<Transaction> rep = getTransaction(hash);
        rep.getResult().setToAddr(Bech32.toBech32Address(rep.getResult().getToAddr()));
        return rep;
    }


    public Rep<TransactionList> getRecentTransactions() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetRecentTransactions").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<TransactionList>>() {
        }.getType();
        Rep<TransactionList> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<List<List<String>>> getTransactionsForTxBlock(String blockNum) throws IOException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetTransactionsForTxBlock").params(new String[]{blockNum}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<List<List<String>>>>() {
        }.getType();
        Rep<List<List<String>>> rep = gson.fromJson(resultString, type);
        if (rep.getResult() == null) {
            Rep<List<List<String>>> res = new Rep<>();
            res.setJsonrpc("2.0");
            res.setId("1");
            JsonObject jb = gson.fromJson(resultString, JsonObject.class);
            res.setErr(jb.getAsJsonObject("error").get("message").toString());
            return res;
        }
        return rep;
    }


    public Rep<String> getNumTxnsTxEpoch() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNumTxnsTxEpoch").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }

    public Rep<String> getNumTxnsDSEpoch() throws IOException, ZilliqaAPIException {
        Req req = Req.builder().id("1").jsonrpc("2.0").method("GetNumTxnsDSEpoch").params(new String[]{""}).build();
        Response response = client.newCall(buildRequest(req)).execute();
        String resultString = Objects.requireNonNull(response.body()).string();
        Type type = new TypeToken<Rep<String>>() {
        }.getType();
        Rep<String> rep = gson.fromJson(resultString, type);
        if (null == rep.getResult()) {
            Pair pair = parseError(resultString);
            throw new ZilliqaAPIException(pair.getMessage(),pair.getCode());
        }
        return rep;
    }


    private Request buildRequest(Req req) throws MalformedURLException {
        RequestBody body = RequestBody.create(JSON, gson.toJson(req));
        return new Request.Builder()
                .post(body)
                .url(new URL(this.url))
                .build();
    }

    @Data
    public static class BalanceResult {
        private String balance;
        private String nonce;
    }

    @Data
    public static class ContractResult {
        private String code;
    }

    @Data
    public static class CreateTxResult {
        private String Info;
        private String TranID;

        @Override
        public String toString() {
            return "CreateTxResult{" +
                    "Info='" + Info + '\'' +
                    ", TranID='" + TranID + '\'' +
                    '}';
        }
    }

    @Data
    @Builder
    public static class Pair {
        private String message;
        private int code;


    }

    public Pair parseError(String error) {
        JsonObject root = gson.fromJson(error, JsonObject.class);
        JsonObject err = root.getAsJsonObject("error");
        return Pair.builder().code(err.get("code").getAsInt()).message(err.get("message").getAsString()).build();

    }


}
