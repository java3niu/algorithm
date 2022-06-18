package site.sanniu.ratelimit;

/**
 * Created by sanniu on 2022/6/18 23:27
 * 令牌桶限流算法
 */
public class TokenBucketRateLimit {
    // 创建令牌时间间隔 单位毫秒
    private long buildTokenTimeGap;
    // 令牌桶容量
    private int capacity;
    // 上一次创建令牌的事件
    private long lastBuildTokenTime;

    public TokenBucketRateLimit(long buildTokenTimeGap, int capacity) {
        this.buildTokenTimeGap = buildTokenTimeGap;
        this.capacity = capacity;
        this.lastBuildTokenTime = System.currentTimeMillis();
    }

    public boolean tryAcquire() {
        if (capacity > 0) {
            capacity--;
            return true;
        }

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastBuildTokenTime >= buildTokenTimeGap) {
            capacity += (int)((currentTime - lastBuildTokenTime) / buildTokenTimeGap);
            lastBuildTokenTime = currentTime;
            if (capacity > 10) {
                capacity = 10;
            };
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucketRateLimit tokenBucketRateLimit = new TokenBucketRateLimit(1000,10);
        while (true) {
            if (tokenBucketRateLimit.tryAcquire()) {
                System.out.println("获取令牌成功，可以执行业务逻辑了");
            } else {
                System.out.println("获取令牌失败，请稍后重试");
            }
        }
    }
}
