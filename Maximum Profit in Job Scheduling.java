class Solution {
   
    private class Job{
        private int startTime;
        private int endTime;
        private int profit;
        
        public Job(int st, int et, int pf){
            this.startTime = st;
            this.endTime = et;
            this.profit = pf;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        List<Job> jobs = new ArrayList<>();
        
        for(int i=0; i<startTime.length; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        
        Collections.sort(jobs, (a,b) -> (a.endTime - b.endTime));
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        
        for(Job currJob : jobs){
            Integer entryTillStartTime = map.floorKey(currJob.startTime);
            int maxProfitTillStartTime = entryTillStartTime == null ? 0 : map.get(entryTillStartTime);
            ans = Math.max(ans, maxProfitTillStartTime + currJob.profit);
            map.put(currJob.endTime, ans);
        }
        return ans;
    }
}