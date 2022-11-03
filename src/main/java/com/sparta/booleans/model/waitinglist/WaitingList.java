package com.sparta.booleans.model.waitinglist;

import com.sparta.booleans.exceptions.TraineeNotFoundException;
import com.sparta.booleans.model.CourseType;
import com.sparta.booleans.model.trainee.Trainee;

import java.util.ArrayList;

public class WaitingList  {

    private static WaitingList waitingList = new WaitingList();

    private Node<Trainee> head;
    private Node<Trainee> tail;

    private WaitingList() {}

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
            return null;
        }

        Node<Trainee> node = head;
        if (head.getElement().getCourseType() == type) {
            return poll();
        }

        while (node.getTail() != null) {
            Node<Trainee> compare = node.getTail();
            if (compare.getElement().getCourseType() == type) {
                node.setTail(compare.getTail());
                return compare.getElement();
            }
            node = node.getTail();
        }
        throw new TraineeNotFoundException();
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
        }
    }

    public void addToFront(Trainee element) {
        Node<Trainee> node = new Node<>(element);
        node.setTail(head);
        head = node;
    }

    public void remove() {
        head = head.getTail();
    }

    public int getSize() {
        if (head == null) {
            return 0;
        }
        Node<Trainee> node = head;
        int size = 0;
        while(node != null) {
            size++;
            node = node.getTail();
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

    public static WaitingList getWaitingList() {
        return waitingList;
    }
}