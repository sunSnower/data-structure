package pointer.linker;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
class Linked {
    private static final int beginValue = 10;
    LinkerNode<Integer> root;

    /**
     * 初始化链表
     * @param numberNodes
     */
    public void initLinder(int numberNodes){
        root = new LinkerNode<Integer>();
        root.setValue(beginValue);
        LinkerNode<Integer> rootNext = new LinkerNode<Integer>();
        rootNext.setValue(beginValue);
        root.setNext(rootNext);
        LinkerNode<Integer> next = null;
        for(int i = 2; i <= numberNodes; i++){
            next = new LinkerNode<Integer>();
            next.setValue(beginValue * i);
            rootNext.setNext(next);
            rootNext = next;
        }
    }

    /**
     * 单链表指针删除指定节点
     * @param node
     */
    public void delectOppintNode(LinkerNode<Integer> node){
        if(root.getValue().equals(node.getValue())){
            if(root.getNext() != null){
                root = root.getNext();
            }
        }
        else{
            LinkerNode<Integer> tempRoot;
            tempRoot = root;
            while(tempRoot.getNext() != null){
                if(tempRoot.getNext().getValue().equals(node.getValue())){
                    if(tempRoot.getNext().getNext() != null){
                        tempRoot.setNext(tempRoot.getNext().getNext());
                    }
                    else{
                        tempRoot.setNext(null);
                    }
                }
                tempRoot = tempRoot.getNext();
            }
        }
    }

    /**
     * 获取不知长度的链表的中间值
     * @return
     */
    public Integer getMiddleLinkerNodeValue(){
        LinkerNode<Integer> skipOneNode = null;
        LinkerNode<Integer> skipTwoNode = null;
        if(root != null){
            skipOneNode = root;
            skipTwoNode = root;
        }
        while(skipTwoNode.getNext().getNext() != null){
            skipOneNode = skipOneNode.getNext();
            skipTwoNode = skipTwoNode.getNext().getNext();
            if(skipTwoNode.getNext() == null){
                return skipOneNode.getValue();
            }
        }

        return null;
    }

    /**
     * 反转链表
     */
    public void inversionLinker(){
        int count = 1;
        LinkerNode<Integer> tempRoot = root;
        while(tempRoot.getNext() != null){
            count++;
            tempRoot = tempRoot.getNext();
        }
        LinkerNode<Integer>[] arr = new LinkerNode[count];
        for(int i = 0; i < arr.length; i++){
            arr[i] = root;
            root = root.getNext();
        }
        for(int i = arr.length-1; i >= 1; i--){
            arr[i].setNext(arr[i-1]);
        }
    }

    /**
     * 判断链表是否有环， 用快慢指针判断
     * @return
     */
    public boolean judgeLinkerHascircle(){
        LinkerNode<Integer> skipOneStep = null;
        LinkerNode<Integer> skipTwoStep = null;
        if(root != null){
            skipOneStep = root;
            skipTwoStep = root;
        }
        while(true){
            if(skipOneStep.getNext() != null){
                skipOneStep = skipOneStep.getNext();
            }
            else{
                break;
            }
            if(skipTwoStep.getNext() != null){
                skipTwoStep = skipTwoStep.getNext().getNext();
            }
            else{
                break;
            }
            if(skipOneStep == skipTwoStep){
                return true;
            }
        }
        return false;
    }

    /**
     * 验证
     * @param args
     */
    public static void main(String[] args){
        Linked linked = new Linked();
        linked.initLinder(10);
        System.out.println(linked.getMiddleLinkerNodeValue());
        System.out.println(linked.judgeLinkerHascircle());
    }
}
