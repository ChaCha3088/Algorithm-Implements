package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FarthestNodeTest {
    Map<Integer, Integer> result = new HashMap<>();
    int[][] vertex;

    @Test
    void solution() {
        int n = 6;
        int answer = 0;
        vertex = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        //2부터 n까지
        for (int i = 2; i <= n; i++) {
            result.put(i, 999999);
        }

        //시작
        for (int targetNode = 2; targetNode <=n; targetNode++) {
            int[] visited = new int[n];
            visited[0] = 1;

            //nextNode 결정 필요
            List<Integer> nextNodeList = findNextNode(1, visited, vertex);
            for (int nextNode : nextNodeList) {
                process(0, visited, targetNode, nextNode);
            }
        }

        // Map.Entry 리스트 작성
        List<Map.Entry<Integer, Integer>> list_entries = new ArrayList<>(result.entrySet());

        // 비교함수 Comparator를 사용하여 내림차순으로 정렬
        Collections.sort(list_entries, (a, b) -> {
            return b.getValue().compareTo(a.getValue());
        });

        int maxValue = list_entries.get(0).getValue();

        for (Map.Entry<Integer, Integer> entry : list_entries) {
            if (entry.getValue().intValue() == maxValue) {
                answer += 1;
            } else {
                break;
            }
        }

        Assertions.assertThat(answer).isEqualTo(3);
    }

    //1로 부터 최소 거리를 구하자
    private void process(int count, int[] visited, int targetNode, int nextNode) {
        int currentCount = count;
        int currentNode = nextNode;

        //visited 복사
        int[] currentVisited = new int[visited.length];
        for (int i = 0; i < visited.length; i++) {
            currentVisited[i] = visited[i];
        }

        //visited 추가
        currentVisited[currentNode - 1] = 1;

        currentCount += 1;

        if (currentCount >= result.get(targetNode)) {
            return;
        }

        //목표 노드와 일치하면
        if (targetNode == currentNode) {
            //최소값이면 업데이트
            result.put(targetNode, Math.min(result.get(targetNode), currentCount));
            return;
        } else if (targetNode != currentNode) {
            //nextNode 결정 필요
            List<Integer> nextNodeList = findNextNode(currentNode, visited, vertex);
            if (nextNodeList.size() == 0) {
                return;
            }
            for (int nextNodei : nextNodeList) {
                process(currentCount, currentVisited, targetNode, nextNodei);
            }
        }
    }

    private List<Integer> findNextNode(int currentNode, int[] visited, int[][] edge) {
        //집합?
        //방문 안한 곳 n 갈 수 있는 곳
        //방문 안한 ts
        Set<Integer> notVisited = new TreeSet<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                notVisited.add(i + 1);
            }
        }

        //갈 수 있는 ts
        Set<Integer> available = new TreeSet<>();
        for (int i = 0; i < edge.length; i++) {
            if (edge[i][0] == currentNode) {
                available.add(edge[i][1]);
            } else if (edge[i][1] == currentNode) {
                available.add(edge[i][0]);
            }
        }

        //교집합
        notVisited.retainAll(available);

        return new ArrayList<>(notVisited);
    }
}
