package org.eurekaclinical.eureka.client.comm;

/*
 * #%L
 * Eureka Common
 * %%
 * Copyright (C) 2012 - 2014 Emory University
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Andrew Post
 */
public class BinaryOperator extends Node {

    public static enum Op {
        AND,
        OR
    }

    private Op op;

    @JsonProperty("left_node")
    private Node leftNode;

    @JsonProperty("right_node")
    private Node rightNode;

    public Op getOp() {
        return op;
    }

    public void setOp(Op op) {
        this.op = op;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "BinaryOperator{" + "op=" + op + ", leftNode=" + leftNode + ", rightNode=" + rightNode + '}';
    }
    
}
