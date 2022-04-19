package com.example.cryptovote.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.StaticArray2;


/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.4.
 */
@SuppressWarnings("rawtypes")
public class Election extends Contract {
    private static final String BINARY = "60806040526000600555600060065534801561001a57600080fd5b506120448061002a6000396000f3fe608060405234801561001057600080fd5b50600436106100ea5760003560e01c806396dfcbea1161008c578063c89830c811610066578063c89830c81461023a578063e6a5e61d14610256578063f851a44014610272578063fa106d4014610290576100ea565b806396dfcbea146101df578063a9a981a3146101fd578063b7e032641461021b576100ea565b80634a2a84c5116100c85780634a2a84c514610145578063704b6c021461016157806379614b2e1461017d5780638f47b146146101ae576100ea565b806302d947ef146100ef57806307e4b70a1461010b57806342169e4814610127575b600080fd5b6101096004803603810190610104919061163d565b6102ac565b005b6101256004803603810190610120919061167d565b6105fe565b005b61012f610734565b60405161013c91906116b9565b60405180910390f35b61015f600480360381019061015a919061181a565b61073a565b005b61017b6004803603810190610176919061167d565b610902565b005b61019760048036038101906101929190611876565b610a24565b6040516101a59291906118a3565b60405180910390f35b6101c860048036038101906101c3919061163d565b610b0d565b6040516101d69291906118a3565b60405180910390f35b6101e7610c23565b6040516101f49190611954565b60405180910390f35b610205610d93565b60405161021291906116b9565b60405180910390f35b610223610d99565b6040516102319291906118a3565b60405180910390f35b610254600480360381019061024f919061167d565b610e78565b005b610270600480360381019061026b919061167d565b610f38565b005b61027a6110ab565b6040516102879190611985565b60405180910390f35b6102aa60048036038101906102a591906119a0565b6110d1565b005b80600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160019054906101000a900460ff161561033d576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161033490611a2c565b60405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020154116103c2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016103b990611a98565b60405180910390fd5b600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610451576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161044890611b04565b60405180910390fd5b8260008111801561046457506005548111155b6104a3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161049a90611b70565b60405180910390fd5b60018060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160016101000a81548160ff02191690831515021790555083600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010181905550600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201546003600086815260200190815260200160002060008282546105a99190611bbf565b925050819055506000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002018190555050505050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161461068f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161068690611c87565b60405180910390fd5b600160028111156106a3576106a2611ca7565b5b600460149054906101000a900460ff1660028111156106c5576106c4611ca7565b5b14610705576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016106fc90611d48565b60405180910390fd5b6002600460146101000a81548160ff0219169083600281111561072b5761072a611ca7565b5b02179055505050565b60065481565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146107cb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107c290611c87565b60405180910390fd5b600060028111156107df576107de611ca7565b5b600460149054906101000a900460ff16600281111561080157610800611ca7565b5b148061083f575060028081111561081b5761081a611ca7565b5b600460149054906101000a900460ff16600281111561083d5761083c611ca7565b5b145b61087e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161087590611db4565b60405180910390fd5b6005600081548092919061089190611dd4565b9190505550600554600260006005548152602001908152602001600020600001819055508260026000600554815260200190815260200160002060010190805190602001906108e19291906114f2565b50600060036000600554815260200190815260200160002081905550505050565b6000600281111561091657610915611ca7565b5b600460149054906101000a900460ff16600281111561093857610937611ca7565b5b1480610976575060028081111561095257610951611ca7565b5b600460149054906101000a900460ff16600281111561097457610973611ca7565b5b145b6109b5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109ac90611db4565b60405180910390fd5b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600460146101000a81548160ff02191690836002811115610a1c57610a1b611ca7565b5b021790555050565b600080600280811115610a3a57610a39611ca7565b5b600460149054906101000a900460ff166002811115610a5c57610a5b611ca7565b5b14610a9c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610a9390611e69565b60405180910390fd5b82600081118015610aaf57506005548111155b610aee576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610ae590611b70565b60405180910390fd5b8360036000868152602001908152602001600020549250925050915091565b60008082600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610ba1576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610b9890611c87565b60405180910390fd5b846001600080600089815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002015492509250509250929050565b606060006002811115610c3957610c38611ca7565b5b600460149054906101000a900460ff166002811115610c5b57610c5a611ca7565b5b1415610c9e576040518060400160405280601681526020017f456c656374696f6e204e6f7420537461727465642121000000000000000000008152509050610d90565b60016002811115610cb257610cb1611ca7565b5b600460149054906101000a900460ff166002811115610cd457610cd3611ca7565b5b1415610d17576040518060400160405280601281526020017f456c656374696f6e2053746172746564212100000000000000000000000000008152509050610d90565b600280811115610d2a57610d29611ca7565b5b600460149054906101000a900460ff166002811115610d4c57610d4b611ca7565b5b1415610d8f576040518060400160405280601081526020017f456c656374696f6e20456e6465642121000000000000000000000000000000008152509050610d90565b5b90565b60055481565b600080600280811115610daf57610dae611ca7565b5b600460149054906101000a900460ff166002811115610dd157610dd0611ca7565b5b14610e11576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610e0890611e69565b60405180910390fd5b60008080600190505b6005548111610e6b578260036000838152602001908152602001600020541115610e5857809150600360008281526020019081526020016000205492505b8080610e6390611dd4565b915050610e1a565b5080829350935050509091565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610f09576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610f0090611c87565b60405180910390fd5b6000600460146101000a81548160ff02191690836002811115610f2f57610f2e611ca7565b5b02179055505050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610fc9576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610fc090611c87565b60405180910390fd5b60006002811115610fdd57610fdc611ca7565b5b600460149054906101000a900460ff166002811115610fff57610ffe611ca7565b5b148061103d575060028081111561101957611018611ca7565b5b600460149054906101000a900460ff16600281111561103b5761103a611ca7565b5b145b61107c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161107390611db4565b60405180910390fd5b6001600460146101000a81548160ff021916908360028111156110a2576110a1611ca7565b5b02179055505050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614611162576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161115990611c87565b60405180910390fd5b82600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156111f4576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016111eb90611efb565b60405180910390fd5b6000600281111561120857611207611ca7565b5b600460149054906101000a900460ff16600281111561122a57611229611ca7565b5b1480611268575060028081111561124457611243611ca7565b5b600460149054906101000a900460ff16600281111561126657611265611ca7565b5b145b6112a7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161129e90611db4565b60405180910390fd5b83600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160019054906101000a900460ff1615801561134757506000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020154145b80156113a05750600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16155b6113df576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016113d690611f8d565b60405180910390fd5b600660008154809291906113f290611dd4565b919050555084600080600654815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002018190555060018060008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548160ff0219169083151502179055505050505050565b8280546114fe90611fdc565b90600052602060002090601f0160209004810192826115205760008555611567565b82601f1061153957805160ff1916838001178555611567565b82800160010185558215611567579182015b8281111561156657825182559160200191906001019061154b565b5b5090506115749190611578565b5090565b5b80821115611591576000816000905550600101611579565b5090565b6000604051905090565b600080fd5b600080fd5b6000819050919050565b6115bc816115a9565b81146115c757600080fd5b50565b6000813590506115d9816115b3565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061160a826115df565b9050919050565b61161a816115ff565b811461162557600080fd5b50565b60008135905061163781611611565b92915050565b600080604083850312156116545761165361159f565b5b6000611662858286016115ca565b925050602061167385828601611628565b9150509250929050565b6000602082840312156116935761169261159f565b5b60006116a184828501611628565b91505092915050565b6116b3816115a9565b82525050565b60006020820190506116ce60008301846116aa565b92915050565b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b611727826116de565b810181811067ffffffffffffffff82111715611746576117456116ef565b5b80604052505050565b6000611759611595565b9050611765828261171e565b919050565b600067ffffffffffffffff821115611785576117846116ef565b5b61178e826116de565b9050602081019050919050565b82818337600083830152505050565b60006117bd6117b88461176a565b61174f565b9050828152602081018484840111156117d9576117d86116d9565b5b6117e484828561179b565b509392505050565b600082601f830112611801576118006116d4565b5b81356118118482602086016117aa565b91505092915050565b600080604083850312156118315761183061159f565b5b600083013567ffffffffffffffff81111561184f5761184e6115a4565b5b61185b858286016117ec565b925050602061186c85828601611628565b9150509250929050565b60006020828403121561188c5761188b61159f565b5b600061189a848285016115ca565b91505092915050565b60006040820190506118b860008301856116aa565b6118c560208301846116aa565b9392505050565b600081519050919050565b600082825260208201905092915050565b60005b838110156119065780820151818401526020810190506118eb565b83811115611915576000848401525b50505050565b6000611926826118cc565b61193081856118d7565b93506119408185602086016118e8565b611949816116de565b840191505092915050565b6000602082019050818103600083015261196e818461191b565b905092915050565b61197f816115ff565b82525050565b600060208201905061199a6000830184611976565b92915050565b600080604083850312156119b7576119b661159f565b5b60006119c585828601611628565b92505060206119d685828601611628565b9150509250929050565b7f54686520566f7465722068617320616c726561647920766f7465642e00000000600082015250565b6000611a16601c836118d7565b9150611a21826119e0565b602082019050919050565b60006020820190508181036000830152611a4581611a09565b9050919050565b7f54686520566f74657220686173206e6f7420766f746564207965742e00000000600082015250565b6000611a82601c836118d7565b9150611a8d82611a4c565b602082019050919050565b60006020820190508181036000830152611ab181611a75565b9050919050565b7f54686520766f746572206973206e6f7420726567697374657265642e00000000600082015250565b6000611aee601c836118d7565b9150611af982611ab8565b602082019050919050565b60006020820190508181036000830152611b1d81611ae1565b9050919050565b7f496e76616c69642043616e6469646174652e0000000000000000000000000000600082015250565b6000611b5a6012836118d7565b9150611b6582611b24565b602082019050919050565b60006020820190508181036000830152611b8981611b4d565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611bca826115a9565b9150611bd5836115a9565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115611c0a57611c09611b90565b5b828201905092915050565b7f4f6e6c7920656c656374696f6e2061646d696e2063616e20616363657373206660008201527f756e6374696f6e21000000000000000000000000000000000000000000000000602082015250565b6000611c716028836118d7565b9150611c7c82611c15565b604082019050919050565b60006020820190508181036000830152611ca081611c64565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b7f54686520656c656374696f6e206973206f6e676f696e67206f7220616c72656160008201527f647920656e6465642e0000000000000000000000000000000000000000000000602082015250565b6000611d326029836118d7565b9150611d3d82611cd6565b604082019050919050565b60006020820190508181036000830152611d6181611d25565b9050919050565b7f54686520656c656374696f6e2068617320616c72656164792073746172746564600082015250565b6000611d9e6020836118d7565b9150611da982611d68565b602082019050919050565b60006020820190508181036000830152611dcd81611d91565b9050919050565b6000611ddf826115a9565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415611e1257611e11611b90565b5b600182019050919050565b7f54686520656c656374696f6e20686173206e6f7420656e646564207965742e00600082015250565b6000611e53601f836118d7565b9150611e5e82611e1d565b602082019050919050565b60006020820190508181036000830152611e8281611e46565b9050919050565b7f54686520656c656374696f6e2061646d696e2063616e6e6f742061636365737360008201527f20746869732066756e6374696f6e000000000000000000000000000000000000602082015250565b6000611ee5602e836118d7565b9150611ef082611e89565b604082019050919050565b60006020820190508181036000830152611f1481611ed8565b9050919050565b7f566f7465722068617320616c7265616479206265656e2072656769737465726560008201527f642e000000000000000000000000000000000000000000000000000000000000602082015250565b6000611f776022836118d7565b9150611f8282611f1b565b604082019050919050565b60006020820190508181036000830152611fa681611f6a565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b60006002820490506001821680611ff457607f821691505b6020821081141561200857612007611fad565b5b5091905056fea264697066735822122003cce37b6baf264027c2d287afbbde4e108060a722110e0918919e91de803f6764736f6c634300080c0033";

    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_ADDVOTER = "addVoter";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_CANDIDATECOUNT = "candidateCount";

    public static final String FUNC_CHECKSTATE = "checkState";

    public static final String FUNC_ENDELECTION = "endElection";

    public static final String FUNC_GETVOTER = "getVoter";

    public static final String FUNC_RESTARTELECTION = "restartElection";

    public static final String FUNC_SETADMIN = "setAdmin";

    public static final String FUNC_SHOWRESULTS = "showResults";

    public static final String FUNC_SHOWWINNER = "showWinner";

    public static final String FUNC_STARTELECTION = "startElection";

    public static final String FUNC_VOTE = "vote";

    public static final String FUNC_VOTERCOUNT = "voterCount";

    @Deprecated
    protected Election(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Election(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Election(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Election(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addCandidate(String _name, String owner) {
        final Function function = new Function(
                FUNC_ADDCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addVoter(String _voter, String owner) {
        final Function function = new Function(
                FUNC_ADDVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> admin() {
        final Function function = new Function(
                FUNC_ADMIN, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> candidateCount() {
        final Function function = new Function(
                FUNC_CANDIDATECOUNT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> checkState() {
        final Function function = new Function(
                FUNC_CHECKSTATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(){}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> endElection(String owner) {
        final Function function = new Function(
                FUNC_ENDELECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> getVoter(BigInteger ID, String owner) {
        final Function function = new Function(
                FUNC_GETVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(ID), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
               Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Uint256>>() { }));
        return new RemoteCall<List>(
                new Callable<List>(){
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception{
                        List<Type> result = executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                }
        );
    }

    public RemoteCall<TransactionReceipt> restartElection(String owner) {
        final Function function = new Function(
                FUNC_RESTARTELECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> setAdmin(String owner) {
        final Function function = new Function(
                FUNC_SETADMIN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<List> showResults(BigInteger _ID) {
        final Function function = new Function(
                FUNC_GETVOTER,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID)),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Uint256>>() { }));
        return new RemoteCall<List>(
                new Callable<List>(){
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception{
                        List<Type> result = executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                }
        );
    }

    public RemoteCall<List> showWinner() {
        final Function function = new Function(
                FUNC_GETVOTER,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<StaticArray2<Uint256>>() { }));
        return new RemoteCall<List>(
                new Callable<List>(){
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception{
                        List<Type> result = executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                }
        );
    }

    public RemoteCall<TransactionReceipt> startElection(String owner) {
        final Function function = new Function(
                FUNC_STARTELECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> vote(BigInteger _ID, String owner) {
        final Function function = new Function(
                FUNC_VOTE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID), 
                new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> voterCount() {
        final Function function = new Function(
                FUNC_VOTERCOUNT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Election load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Election(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Election load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Election(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Election load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Election(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Election load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Election(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Election> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Election.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Election> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Election.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Election> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Election.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Election> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Election.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
