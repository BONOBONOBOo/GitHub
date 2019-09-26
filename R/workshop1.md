dau <- read.csv("./data/ws3-dau.csv", header=TRUE)
userinfo <- read.csv("./data/ws3-user_info.csv", header=TRUE)

head(dau)
head(userinfo)

dau_df <- data.frame(dau)
userinfo_df <- data.frame(userinfo)

head(dau_df)
head(userinfo_df)

length(dau$log_date)
length(userinfo$install_date)

userinfo_mg <- merge(x=dau_df,y=userinfo_df,by="user_id")
head(userinfo_mg)

table(userinfo_mg$install_date)

userinfo_mg$month[as.Date(userinfo_mg$log_date)>=as.Date("2013-08-01")||as.Date(userinfo_mg$log_date)<as.Date("2013-08-31")]
userinfo_mg$log_month <- substr(userinfo_mg$log_date,1,7)
log_month <- data.frame(log_month)
head(log_month)

month.gender <- table(userinfo_mg$log_month,userinfo_mg$gender)
head(month.gender)


table(userinfo_mg$log_month,userinfo_mg$generation)

table(userinfo_mg$log_month,userinfo_mg$generation,userinfo_mg$gender)
month.gender_df <- as.data.frame(month.gender)




require("ggplot2")

ggplot(data=month.gender_df,aes(x=month.gender_df$Var2,y=month.gender_df$Var1)) + geom_line(aes(group=month.gender_df$Var2))



pp<-as.data.frame(table(userinfo_mg$log_date,userinfo_mg$device_type))

head(pp)

ggplot(data=pp,aes(x=pp$Var1,y=pp$Freq)) + geom_line(aes(group=pp$Var2),color="red")


# # 단계1 : 실행환경으로 데이터 로딩
# dau <- read.csv("./data/ws3-dau.csv", header = T, stringsAsFactors = F)
# head(dau)
# user.info <- read.csv("./data/ws3-user_info.csv", header = T, stringsAsFactors = F)
# head(user.info)
# 
# # 단계2 : DAU데이터에 user.info 데이터 결합하기
# dau.user.info <- merge(dau, user.info, by = c("user_id", "app_name"))
# head(dau.user.info)
# 
# # 단계3 : 세그먼트 분석 (성별로 집계, 연령대별 집계, 성별+연령대별 집계, device별 집계)
# # 월 항목을 추가
# dau.user.info$log_month <- substr(dau.user.info$log_date, 1, 7)
# # 세그먼트 분석（성별로 집계）
# table(dau.user.info[, c("log_month", "gender")])
# 
# # 세그먼트 분석(연령대별로 집계）
# table(dau.user.info[, c("log_month", "generation")])
# 
# # 세그먼트 분석（성별과 연령대를 조합해 집계）
# library(reshape2)
# dcast(dau.user.info, log_month ~ gender + generation, value.var = "user_id",
#       length)
# 
# # 세그먼트 분석（단말기별로 집계）
# table(dau.user.info[,c("log_month","device_type")])
# 
# 
# 
# # 단계4 : 가장 빈도수 차이가 큰 세그먼트 분석 결과를 시각화
# 
# # 날짜별로 단말기별 유저수를 산출하기
# dau.user.info.device.summary <- ddply(dau.user.info, .(log_date, device_type), summarize, dau = length(user_id))
# # 날짜별 데이터 형식으로 변환하기
# dau.user.info.device.summary$log_date <- as.Date(dau.user.info.device.summary$log_date)
# # 시계열의 트렌드 그래프 그리기
# library(ggplot2)
# library(scales)
# limits <- c(0, max(dau.user.info.device.summary$dau))
# ggplot(dau.user.info.device.summary, aes(x=log_date, y=dau, col=device_type, lty=device_type, shape=device_type)) +
#   geom_line(lwd=1) +
#   geom_point(size=4) +
#   scale_y_continuous(label=comma, limits=limits)
# 
# table(unique(dau.user.info[, c("log_month", "gender", "user_id")]))


























​       