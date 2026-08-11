package programmers.lv3.p42627;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
	// 작업 하나의 정보를 저장하는 클래스
    static class Job {
        int number;         // 작업 번호
        int requestTime;    // 요청 시각
        int duration;       // 소요 시간

        Job(int number, int requestTime, int duration) {
            this.number = number;
            this.requestTime = requestTime;
            this.duration = duration;
        }
    }

    public int solution(int[][] jobs) {

        // 1. jobs 배열을 Job 객체로 변환한다.
        List<Job> jobList = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            int requestTime = jobs[i][0];
            int duration = jobs[i][1];

            jobList.add(new Job(i, requestTime, duration));
        }

        // 2. 아직 대기 큐에 넣지 않은 작업을
        //    요청 시각 순서대로 확인하기 위해 정렬한다.
        jobList.sort((job1, job2) -> {
            if (job1.requestTime != job2.requestTime) {
                return Integer.compare(
                        job1.requestTime,
                        job2.requestTime
                );
            }

            // 요청 시각이 같으면 작업 번호가 작은 순서
            return Integer.compare(
                    job1.number,
                    job2.number
            );
        });

        // 3. 현재 시각까지 요청된 작업을 저장하는 대기 큐
        PriorityQueue<Job> waitingQueue = new PriorityQueue<>(
                (job1, job2) -> {

                    // 1순위: 소요 시간이 짧은 작업
                    if (job1.duration != job2.duration) {
                        return Integer.compare(
                                job1.duration,
                                job2.duration
                        );
                    }

                    // 2순위: 요청 시각이 빠른 작업
                    if (job1.requestTime != job2.requestTime) {
                        return Integer.compare(
                                job1.requestTime,
                                job2.requestTime
                        );
                    }

                    // 3순위: 작업 번호가 작은 작업
                    return Integer.compare(
                            job1.number,
                            job2.number
                    );
                }
        );

        int currentTime = 0;       // 현재 시각
        int nextJobIndex = 0;      // 다음에 대기 큐에 넣을 작업 위치
        int completedCount = 0;    // 완료한 작업 개수

        long totalTurnaroundTime = 0;

        // 모든 작업을 완료할 때까지 반복
        while (completedCount < jobs.length) {

            /*
             * 현재 시각까지 요청된 작업을 모두 대기 큐에 넣는다.
             *
             * if가 아니라 while이어야 한다.
             * 현재 시각까지 여러 작업이 들어왔을 수 있기 때문이다.
             */
            while (
                    nextJobIndex < jobList.size()
                    && jobList.get(nextJobIndex).requestTime <= currentTime
            ) {
                waitingQueue.offer(jobList.get(nextJobIndex));
                nextJobIndex++;
            }

            /*
             * 현재 실행할 수 있는 작업이 없다면
             * 다음 작업의 요청 시각으로 바로 이동한다.
             */
            if (waitingQueue.isEmpty()) {
                currentTime = jobList.get(nextJobIndex).requestTime;
                continue;
            }

            // 우선순위가 가장 높은 작업을 꺼낸다.
            Job currentJob = waitingQueue.poll();

            // 작업이 끝나는 시점으로 현재 시각을 이동한다.
            currentTime += currentJob.duration;

            // 반환 시간 = 종료 시각 - 요청 시각
            totalTurnaroundTime +=
                    currentTime - currentJob.requestTime;

            completedCount++;
        }

        // 정수 나눗셈이므로 평균의 정수 부분만 반환된다.
        return (int) (totalTurnaroundTime / jobs.length);
    }
}