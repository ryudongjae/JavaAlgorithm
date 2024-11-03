package programmers;

import java.util.*;

public class homework {
    public List<String> solution(String[][] plans) {
        Stack<Homework> waitingWork = new Stack<>();

        PriorityQueue<Homework> homeworkPriorityQueue = new PriorityQueue<>((s1, s2) -> s1.startTime - s2.startTime);

        List<String> completeHomeworkList = new ArrayList<>();

        Arrays.stream(plans).forEach(plan ->
                homeworkPriorityQueue.add(new Homework(plan[0], plan[1], plan[2]))
        );

        while (!homeworkPriorityQueue.isEmpty()) {

            Homework nowWork = homeworkPriorityQueue.poll();

            String currentName = nowWork.name;
            int currentStartTime = nowWork.startTime;
            int progressTime = nowWork.progressTime;


            int currentTime = currentStartTime;

            //새로운 과제가 있는 경우
            if (!homeworkPriorityQueue.isEmpty()) {
                //비교를 위해 다음 과제
                Homework nextWork = homeworkPriorityQueue.peek();

                if (currentStartTime + progressTime < nextWork.startTime) {
                    completeHomeworkList.add(currentName);
                    currentTime += progressTime;

                    while (!waitingWork.isEmpty()) {
                        Homework waitWork = waitingWork.pop();

                        if (currentTime + waitWork.progressTime <= nextWork.startTime) {
                            currentTime += waitWork.progressTime;
                            completeHomeworkList.add(waitWork.name);
                            continue;
                        } else {
                            int remainingTime = waitWork.progressTime - (nextWork.startTime - currentTime);
                            waitingWork.push(new Homework(waitWork.name, remainingTime));
                            break;
                        }

                    }

                } else if (currentStartTime + progressTime == nextWork.startTime) {
                    completeHomeworkList.add(currentName);
                    continue;
                } else {
                    int t = (nextWork.startTime - currentTime);
                    waitingWork.push(new Homework(currentName, progressTime - t));
                }
            } else {

                // 남아있는 과제(잠시 멈춘 과제)도 없는 경우
                if (waitingWork.isEmpty()) {
                    currentTime += progressTime;
                    completeHomeworkList.add(currentName);
                }
                // 남아있는 과제는 있는 경우
                else {
                    completeHomeworkList.add(currentName); // 새로운 과제부터 먼저 해결

                    // 남아있는 과제들을 정해진 순서대로 끝내면 됨
                    while (!waitingWork.isEmpty()) {
                        Homework rem = waitingWork.pop();
                        completeHomeworkList.add(rem.name);
                    }
                }

            }
        }


        return completeHomeworkList;
    }


    class Homework {
        String name;
        int startTime;
        int progressTime;

        public Homework(String name, String startTime, String progressTime) {
            this.name = name;
            this.startTime = changeMinute(startTime);
            this.progressTime = Integer.valueOf(progressTime);
        }

        public Homework(String name, int progressTime) {
            this.name = name;
            this.progressTime = progressTime;
        }

        public int changeMinute(String time) {
            String[] split = time.split(":");
            int hour = Integer.valueOf(split[0]) * 60;
            int minute = Integer.valueOf(split[1]);

            return hour + minute;
        }
    }


}
