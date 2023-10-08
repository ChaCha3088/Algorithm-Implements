package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteTest {
    private List<List<String>> result = new ArrayList<>();

    @Test
    void a() {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        //티켓 생성
        List<List<String>> ticketList = new ArrayList<>();

        for (int i = 0; i < tickets.length; i++) {
            List<String> ticket = new ArrayList<>();
            ticket.add(tickets[i][0]);
            ticket.add(tickets[i][1]);
            ticketList.add(ticket);
        }

        //process
        process("ICN", new ArrayList<>(), ticketList);

        //결과가 리스트에 담기면 좋겠어


        //리스트.size()가 >=2 이면
        //알파벳 순서 비교하자
        if (result.size() >= 2) {
            List<String> compare = new ArrayList<>();
            for (List<String> l : result) {
                String all = String.join(",", l);
                compare.add(all);
            }

            String[] answer = compare.stream()
                    .sorted()
                    .findFirst()
                    .get()
                    .split(",");
            return;
        }

        //
        String[] answer = new String[result.get(0).size()];

        for (int i = 0; i < result.get(0).size(); i++) {
            answer[i] = result.get(0).get(i);
        }

        System.out.println("answer = " + answer);
    }

    private void process(String depart, List<String> routes, List<List<String>> ticketList) {
        List<List<String>> personalTicket = deepCopy(ticketList);
        List<String> routeList = new ArrayList<>(routes);

        //출발지 기록
        routeList.add(depart);

        //티켓이 남아있는지 확인
        if (personalTicket.size() == 0) {
            //결과 저장 후
            result.add(routeList);
            return;
        }

        //personalTicket에서 depart와 일치하는 것을 찾아 리스트에 넣는다.
        List<String> availableArrival = new ArrayList<>();
        List<Integer> ticketIndex = new ArrayList<>();

        for (int i = 0; i < personalTicket.size(); i++) {
            if (personalTicket.get(i).get(0).equals(depart)) {
                availableArrival.add(personalTicket.get(i).get(1));
                ticketIndex.add(i);
            }
        }

        //갈 곳이 있으면
        if (availableArrival.size() > 0) {
            for (int i = 0; i < availableArrival.size(); i++) {
                //그 티켓 사용하고
                List<List<String>> renewedTicket = new ArrayList<>();
                renewedTicket = deepCopy(personalTicket);
                renewedTicket.remove(ticketIndex.get(i).intValue());

                //그 곳으로 보낸다.
                process(availableArrival.get(i), routeList, renewedTicket);
            }
        }
    }

    private List<List<String>> deepCopy(List<List<String>> input) {
        List<List<String>> personalTicket = new ArrayList<>();
        for (List<String> t : input) {
            List<String> list = new ArrayList<>();
            for (String s : t) {
                list.add(s);
            }
            personalTicket.add(list);
        }
        return personalTicket;
    }
}
