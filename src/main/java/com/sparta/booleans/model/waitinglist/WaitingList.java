package com.sparta.booleans.model.waitinglist;

import com.sparta.booleans.exceptions.TraineeNotFoundException;
import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.trainee.Trainee;

import java.util.ArrayList;

public class WaitingList  {

    private Node<Trainee> head;
    private Node<Trainee> tail;

    private int size = 0;

    public Trainee poll() {
        if (head == null) {
            return null;
        }

        Node<Trainee> oldHead = head;
        remove();
        return oldHead.getElement();
    }

    public Trainee pollType(CourseType type) throws TraineeNotFoundException {
        if (head == null) {
            throw new TraineeNotFoundException();
        }

        Node<Trainee> node = head;
        if (head.getElement().getCourseType() == type) {
            return poll();
        }

        while (node != null) {
            if (node.getElement().getCourseType() == type) {
                return getTraineeInMiddle(node);
            }
            node = node.getTail();
        }
        throw new TraineeNotFoundException();
    }

    private Trainee getTraineeInMiddle(Node node) {
        ArrayList<Trainee> addBack = new ArrayList<>();
        while (head != node) {
            addBack.add(poll());
        }
        Trainee found = poll();
        for (Trainee trainee: addBack) {
            addToFront(trainee);
        }
        return found;
    }

    public Trainee peek() {
        if (head == null) {
            return null;
        }
        return head.getElement();
    }

    public void add(Trainee... trainees) {
        for (Trainee trainee: trainees) {
            Node<Trainee> newTail = new Node<>(trainee);
            if (head == null) {
                head = newTail;
            } else {
                tail.setTail(newTail);
            }
            tail = newTail;
            size++;
        }
    }

    public void addToFront(Trainee element) {
        Node<Trainee> node = new Node<>(element);
        node.setTail(head);
        head = node;
        size++;
    }

    public void remove() {
        head = head.getTail();
        size--;
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        return size;
    }

    public ArrayList<Trainee> toArrayList() {
        ArrayList<Trainee> trainees = new ArrayList<>();
        if (head != null) {
            Node<Trainee> node = head;
            while (node != null) {
                trainees.add(node.getElement());
                node = node.getTail();
            }
        }
        return trainees;
    }
}
