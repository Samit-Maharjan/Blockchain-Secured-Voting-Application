package com.example.cryptovote.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.StaticArray2;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
    private static final String BINARY = "60806040526000600555600060065534801561001a57600080fd5b506122678061002a6000396000f3fe608060405234801561001057600080fd5b506004361061012c5760003560e01c8063933d3f3c116100ad578063e6a5e61d11610071578063e6a5e61d14610333578063eb40afc01461034f578063ee2574af1461036b578063f4ab9adf1461039b578063f851a440146103b75761012c565b8063933d3f3c1461028b57806396dfcbea146102a9578063a9a981a3146102c7578063b6bc154d146102e5578063e13804a7146103035761012c565b80634a2a84c5116100f45780634a2a84c5146101d35780636f6233a3146101ef578063704b6c021461020d57806379614b2e146102295780638f47b1461461025a5761012c565b806302d947ef1461013157806307e4b70a1461014d57806309eef43e146101695780631ea9f0f51461019957806342169e48146101b5575b600080fd5b61014b60048036038101906101469190611896565b6103d5565b005b610167600480360381019061016291906118d6565b61070e565b005b610183600480360381019061017e91906118d6565b610844565b604051610190919061191e565b60405180910390f35b6101b360048036038101906101ae91906118d6565b610892565b005b6101bd61096d565b6040516101ca9190611948565b60405180910390f35b6101ed60048036038101906101e89190611aa9565b610973565b005b6101f7610b3b565b604051610204919061191e565b60405180910390f35b610227600480360381019061022291906118d6565b610b89565b005b610243600480360381019061023e9190611b05565b610cab565b604051610251929190611b32565b60405180910390f35b610274600480360381019061026f9190611896565b610d1f565b604051610282929190611b32565b60405180910390f35b610293610e35565b6040516102a09190611948565b60405180910390f35b6102b1610e3f565b6040516102be9190611be3565b60405180910390f35b6102cf610faf565b6040516102dc9190611948565b60405180910390f35b6102ed610fb5565b6040516102fa9190611948565b60405180910390f35b61031d60048036038101906103189190611b05565b610fbf565b60405161032a9190611be3565b60405180910390f35b61034d600480360381019061034891906118d6565b6110ba565b005b61036960048036038101906103649190611c05565b61122d565b005b610385600480360381019061038091906118d6565b6113d0565b604051610392919061191e565b60405180910390f35b6103b560048036038101906103b091906118d6565b611429565b005b6103bf611725565b6040516103cc9190611c54565b60405180910390f35b600160028111156103e9576103e8611c6f565b5b600460149054906101000a900460ff16600281111561040b5761040a611c6f565b5b1461044b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161044290611d10565b60405180910390fd5b806000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002015414156104d2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104c990611d7c565b60405180910390fd5b600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610561576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161055890611de8565b60405180910390fd5b8260008111801561057457506005548111155b6105b3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105aa90611e54565b60405180910390fd5b60018060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160016101000a81548160ff02191690831515021790555083600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010181905550600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201546003600086815260200190815260200160002060008282546106b99190611ea3565b925050819055506000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002018190555050505050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161461079f576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161079690611f6b565b60405180910390fd5b600160028111156107b3576107b2611c6f565b5b600460149054906101000a900460ff1660028111156107d5576107d4611c6f565b5b14610815576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161080c90611d10565b60405180910390fd5b6002600460146101000a81548160ff0219169083600281111561083b5761083a611c6f565b5b02179055505050565b600080600160008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020154149050919050565b80600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16610922576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161091990611fd7565b60405180910390fd5b60018060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201819055505050565b60065481565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610a04576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016109fb90611f6b565b60405180910390fd5b60006002811115610a1857610a17611c6f565b5b600460149054906101000a900460ff166002811115610a3a57610a39611c6f565b5b1480610a785750600280811115610a5457610a53611c6f565b5b600460149054906101000a900460ff166002811115610a7657610a75611c6f565b5b145b610ab7576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610aae90612043565b60405180910390fd5b60056000815480929190610aca90612063565b919050555060055460026000600554815260200190815260200160002060000181905550826002600060055481526020019081526020016000206001019080519060200190610b1a92919061174b565b50600060036000600554815260200190815260200160002081905550505050565b600060016002811115610b5157610b50611c6f565b5b600460149054906101000a900460ff166002811115610b7357610b72611c6f565b5b14610b815760009050610b86565b600190505b90565b60006002811115610b9d57610b9c611c6f565b5b600460149054906101000a900460ff166002811115610bbf57610bbe611c6f565b5b1480610bfd5750600280811115610bd957610bd8611c6f565b5b600460149054906101000a900460ff166002811115610bfb57610bfa611c6f565b5b145b610c3c576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610c3390612043565b60405180910390fd5b80600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600460146101000a81548160ff02191690836002811115610ca357610ca2611c6f565b5b021790555050565b60008082600081118015610cc157506005548111155b610d00576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610cf790611e54565b60405180910390fd5b8360036000868152602001908152602001600020549250925050915091565b60008082600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614610db3576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401610daa90611f6b565b60405180910390fd5b846001600080600089815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002015492509250509250929050565b6000600554905090565b606060006002811115610e5557610e54611c6f565b5b600460149054906101000a900460ff166002811115610e7757610e76611c6f565b5b1415610eba576040518060400160405280601681526020017f456c656374696f6e204e6f7420537461727465642121000000000000000000008152509050610fac565b60016002811115610ece57610ecd611c6f565b5b600460149054906101000a900460ff166002811115610ef057610eef611c6f565b5b1415610f33576040518060400160405280601281526020017f456c656374696f6e2053746172746564212100000000000000000000000000008152509050610fac565b600280811115610f4657610f45611c6f565b5b600460149054906101000a900460ff166002811115610f6857610f67611c6f565b5b1415610fab576040518060400160405280601081526020017f456c656374696f6e20456e6465642121000000000000000000000000000000008152509050610fac565b5b90565b60055481565b6000600654905090565b606081600081118015610fd457506005548111155b611013576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161100a90611e54565b60405180910390fd5b600260008481526020019081526020016000206001018054611034906120db565b80601f0160208091040260200160405190810160405280929190818152602001828054611060906120db565b80156110ad5780601f10611082576101008083540402835291602001916110ad565b820191906000526020600020905b81548152906001019060200180831161109057829003601f168201915b5050505050915050919050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff161461114b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161114290611f6b565b60405180910390fd5b6000600281111561115f5761115e611c6f565b5b600460149054906101000a900460ff16600281111561118157611180611c6f565b5b14806111bf575060028081111561119b5761119a611c6f565b5b600460149054906101000a900460ff1660028111156111bd576111bc611c6f565b5b145b6111fe576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016111f590612043565b60405180910390fd5b6001600460146101000a81548160ff0219169083600281111561122457611223611c6f565b5b02179055505050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff16146112be576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016112b590611f6b565b60405180910390fd5b600060028111156112d2576112d1611c6f565b5b600460149054906101000a900460ff1660028111156112f4576112f3611c6f565b5b1480611332575060028081111561130e5761130d611c6f565b5b600460149054906101000a900460ff1660028111156113305761132f611c6f565b5b145b611371576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161136890612043565b60405180910390fd5b60018060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548160ff021916908315150217905550505050565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff169050919050565b80600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156114bb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016114b29061217f565b60405180910390fd5b600060028111156114cf576114ce611c6f565b5b600460149054906101000a900460ff1660028111156114f1576114f0611c6f565b5b148061152f575060028081111561150b5761150a611c6f565b5b600460149054906101000a900460ff16600281111561152d5761152c611c6f565b5b145b61156e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161156590612043565b60405180910390fd5b81600160008273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160009054906101000a900460ff16156115ff576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016115f690612211565b60405180910390fd5b6006600081548092919061161290612063565b919050555082600080600654815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548160ff0219169083151502179055506000600160008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160016101000a81548160ff021916908315150217905550505050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b828054611757906120db565b90600052602060002090601f01602090048101928261177957600085556117c0565b82601f1061179257805160ff19168380011785556117c0565b828001600101855582156117c0579182015b828111156117bf5782518255916020019190600101906117a4565b5b5090506117cd91906117d1565b5090565b5b808211156117ea5760008160009055506001016117d2565b5090565b6000604051905090565b600080fd5b600080fd5b6000819050919050565b61181581611802565b811461182057600080fd5b50565b6000813590506118328161180c565b92915050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061186382611838565b9050919050565b61187381611858565b811461187e57600080fd5b50565b6000813590506118908161186a565b92915050565b600080604083850312156118ad576118ac6117f8565b5b60006118bb85828601611823565b92505060206118cc85828601611881565b9150509250929050565b6000602082840312156118ec576118eb6117f8565b5b60006118fa84828501611881565b91505092915050565b60008115159050919050565b61191881611903565b82525050565b6000602082019050611933600083018461190f565b92915050565b61194281611802565b82525050565b600060208201905061195d6000830184611939565b92915050565b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6119b68261196d565b810181811067ffffffffffffffff821117156119d5576119d461197e565b5b80604052505050565b60006119e86117ee565b90506119f482826119ad565b919050565b600067ffffffffffffffff821115611a1457611a1361197e565b5b611a1d8261196d565b9050602081019050919050565b82818337600083830152505050565b6000611a4c611a47846119f9565b6119de565b905082815260208101848484011115611a6857611a67611968565b5b611a73848285611a2a565b509392505050565b600082601f830112611a9057611a8f611963565b5b8135611aa0848260208601611a39565b91505092915050565b60008060408385031215611ac057611abf6117f8565b5b600083013567ffffffffffffffff811115611ade57611add6117fd565b5b611aea85828601611a7b565b9250506020611afb85828601611881565b9150509250929050565b600060208284031215611b1b57611b1a6117f8565b5b6000611b2984828501611823565b91505092915050565b6000604082019050611b476000830185611939565b611b546020830184611939565b9392505050565b600081519050919050565b600082825260208201905092915050565b60005b83811015611b95578082015181840152602081019050611b7a565b83811115611ba4576000848401525b50505050565b6000611bb582611b5b565b611bbf8185611b66565b9350611bcf818560208601611b77565b611bd88161196d565b840191505092915050565b60006020820190508181036000830152611bfd8184611baa565b905092915050565b60008060408385031215611c1c57611c1b6117f8565b5b6000611c2a85828601611881565b9250506020611c3b85828601611881565b9150509250929050565b611c4e81611858565b82525050565b6000602082019050611c696000830184611c45565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602160045260246000fd5b7f54686520656c656374696f6e20686173206e6f742073746172746564206f722060008201527f616c726561647920656e6465642e000000000000000000000000000000000000602082015250565b6000611cfa602e83611b66565b9150611d0582611c9e565b604082019050919050565b60006020820190508181036000830152611d2981611ced565b9050919050565b7f54686520566f7465722068617320616c726561647920766f7465642e00000000600082015250565b6000611d66601c83611b66565b9150611d7182611d30565b602082019050919050565b60006020820190508181036000830152611d9581611d59565b9050919050565b7f54686520766f746572206973206e6f7420726567697374657265642e00000000600082015250565b6000611dd2601c83611b66565b9150611ddd82611d9c565b602082019050919050565b60006020820190508181036000830152611e0181611dc5565b9050919050565b7f496e76616c69642043616e6469646174652e0000000000000000000000000000600082015250565b6000611e3e601283611b66565b9150611e4982611e08565b602082019050919050565b60006020820190508181036000830152611e6d81611e31565b9050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000611eae82611802565b9150611eb983611802565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff03821115611eee57611eed611e74565b5b828201905092915050565b7f4f6e6c7920656c656374696f6e2061646d696e2063616e20616363657373206660008201527f756e6374696f6e21000000000000000000000000000000000000000000000000602082015250565b6000611f55602883611b66565b9150611f6082611ef9565b604082019050919050565b60006020820190508181036000830152611f8481611f48565b9050919050565b7f566f74657220686173206e6f74206265656e20726567697374657265642e0000600082015250565b6000611fc1601e83611b66565b9150611fcc82611f8b565b602082019050919050565b60006020820190508181036000830152611ff081611fb4565b9050919050565b7f54686520656c656374696f6e2068617320616c72656164792073746172746564600082015250565b600061202d602083611b66565b915061203882611ff7565b602082019050919050565b6000602082019050818103600083015261205c81612020565b9050919050565b600061206e82611802565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156120a1576120a0611e74565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b600060028204905060018216806120f357607f821691505b60208210811415612107576121066120ac565b5b50919050565b7f54686520656c656374696f6e2061646d696e2063616e6e6f742061636365737360008201527f20746869732066756e6374696f6e000000000000000000000000000000000000602082015250565b6000612169602e83611b66565b91506121748261210d565b604082019050919050565b600060208201905081810360008301526121988161215c565b9050919050565b7f566f7465722068617320616c7265616479206265656e2072656769737465726560008201527f642e000000000000000000000000000000000000000000000000000000000000602082015250565b60006121fb602283611b66565b91506122068261219f565b604082019050919050565b6000602082019050818103600083015261222a816121ee565b905091905056fea264697066735822122037fe5bb94b69feedf34e9d8077f8c64fe73059267e2bad7e16d1c5aab00d350364736f6c634300080c0033";

    public static final String FUNC_ADDCANDIDATE = "addCandidate";

    public static final String FUNC_ADDVOTER = "addVoter";

    public static final String FUNC_ADMIN = "admin";

    public static final String FUNC_CANDIDATECOUNT = "candidateCount";

    public static final String FUNC_CHECKELECTIONSTART = "checkElectionStart";

    public static final String FUNC_CHECKREGISTERED = "checkRegistered";

    public static final String FUNC_CHECKSTATE = "checkState";

    public static final String FUNC_ENDELECTION = "endElection";

    public static final String FUNC_GETCANDIDATENAME = "getCandidateName";

    public static final String FUNC_GETVOTER = "getVoter";

    public static final String FUNC_GIVEVOTERWEIGHT = "giveVoterWeight";

    public static final String FUNC_HASVOTED = "hasVoted";

    public static final String FUNC_SETADMIN = "setAdmin";

    public static final String FUNC_SHOWRESULTS = "showResults";

    public static final String FUNC_STARTELECTION = "startElection";

    public static final String FUNC_VERIFYVOTER = "verifyVoter";

    public static final String FUNC_RETURNCANDIDATECOUNT = "returnCandidateCount";

    public static final String FUNC_RETURNVOTERCOUNT = "returnVoterCount";

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

    public RemoteCall<TransactionReceipt> addVoter(String _voter) {
        final Function function = new Function(
                FUNC_ADDVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter)), 
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

    public RemoteCall<Boolean> checkElectionStart() {
        final Function function = new Function(
                FUNC_CHECKELECTIONSTART, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference <Bool>(){} ));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Boolean> checkRegistered(String _voter) {
        final Function function = new Function(
                FUNC_CHECKREGISTERED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
       return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public RemoteCall<String> getCandidateName(BigInteger _ID) {
        final Function function = new Function(
                FUNC_GETCANDIDATENAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_ID)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>(){} ));
       return executeRemoteCallSingleValueReturn(function, String.class);
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

    public RemoteCall<Boolean> hasVoted(String _voter) {
        final Function function = new Function(
                FUNC_HASVOTED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>(){}));
       return executeRemoteCallSingleValueReturn(function, Boolean.class);
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
                FUNC_SHOWRESULTS,
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

    public RemoteCall<TransactionReceipt> startElection(String owner) {
        final Function function = new Function(
                FUNC_STARTELECTION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, owner)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> verifyVoter(String _voter, String owner) {
        final Function function = new Function(
                FUNC_VERIFYVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter),
                new org.web3j.abi.datatypes.Address(160, owner)), 
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
    
    public RemoteCall<BigInteger> returnCandidateCount(){
        final Function function = new Function(
            FUNC_RETURNCANDIDATECOUNT,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){})
                );
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> returnVoterCount(){
        final Function function = new Function(
            FUNC_RETURNVOTERCOUNT,
            Arrays.<Type>asList(),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(){})
                );
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }
    
    public RemoteCall<TransactionReceipt> giveVoterWeight(String _voter){
        final Function function  = new Function(
                FUNC_GIVEVOTERWEIGHT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _voter)),
                Collections.<TypeReference<?>>emptyList()
                );
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

