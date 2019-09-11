```R
install.packages('rvest')

library(rvest)

#스크래핑할 웹 사이트 URL을 변수에 저장
url <- 'http://www.imdb.com/search/title?count=100&release_date=2016,2016&title_type=feature'

#웹 사이트로부터  HTML code 읽기
webpage <- read_html(url)   
webpage

header_data <- html_nodes(webpage,".lister-item-header a")

#랭킹
#랭킹이 포함된 CSS selector를 찾아서 R 코드로 가져오기
rank_data_html <- html_nodes(webpage,'.text-primary')

#랭킹 데이터를 텍스트로 가져오기
rank_data <- html_text(rank_data_html)
head(rank_data)

#랭킹 데이터를 수치형 데이터로 변환
rank_data<-as.numeric(rank_data) 
head(rank_data)
#str(rank_data)
#length(rank_data)



#title <- html_children(header_data)
title <- html_text(header_data)
title



#설명 가져오기
description <- html_nodes(webpage,".ratings-bar+ .text-muted")
description <- html_text(description)

description_data <- gsub("\n","",description)
description_data

#공백 지우기
library(stringr)
description_data <- str_trim(description_data)
description_data

#런타임 얻기
runtime <- html_nodes(webpage,".runtime")
runtime <- html_text(runtime)
runtime_data <-gsub(" min","",runtime)



#runtime_data <- str_trim(runtime_data)

runtime_data <- as.numeric(runtime_data)
runtime_data

#장르 얻기
genre <- html_nodes(webpage,".genre")
genre <- html_text(genre)
genre <- gsub("\n","",genre)
genre <- gsub(" ","",genre)
genre_data <- as.factor(gsub(",.*","",genre))




#별점 얻기
rating <- html_nodes(webpage,".ratings-imdb-rating strong")
rating_data <- as.numeric(html_text(rating))
rating_data

#추천인원
voting <- html_text(html_nodes(webpage,".sort-num_votes-visible span:nth-child(2)"))
voting <-as.numeric(gsub(",","",voting))

#감독
director <- html_nodes(webpage,".lister-item-content p:nth-child(5) a:nth-child(1)")
director <- html_text(director)
director

#배우
actor <- html_nodes(webpage,".lister-item-content .ghost+ a")
actor <- html_text(actor)
actor 


#메타 스코어어
# metascore 영역의 CSS selectors를 이용한 스크래핑
metascore_data_html <- html_nodes(webpage,'.metascore')

# metascore 데이터 text로 가져오기
metascore_data <- html_text(metascore_data_html)
head(metascore_data)


#1개 이상의 공백 제거
metascore_data<-gsub(" ","",metascore_data)
length(metascore_data)
metascore_data

#metascore 누락된 데이터  NA처리하기  - 29,58, 73, 96
for (i in c(29,58, 73, 96)){
  a<-metascore_data[1:(i-1)]    #리스트로 확인
  b<-metascore_data[i:length(metascore_data)]
  metascore_data<-append(a,list("NA"))
  metascore_data<-append(metascore_data,b)
}
metascore_data

# metascore  데이터를 numerical으로 변환 데이터 처리
metascore_data<-as.numeric(metascore_data)

# metascore  데이터 개수 확인
length(metascore_data) 
metascore_data


#총 수입
#gross<-gsub("[^[:alnum:][:blank:]+?&/\\-]", "", gross)
#gross revenue(총수익)  영역의 CSS selectors를 이용한 스크래핑

gross_data_html <- html_nodes(webpage,'.ghost~ .text-muted+ span')

#gross revenue(총수익) 데이터 text로 가져오기
gross_data <- html_text(gross_data_html)
head(gross_data)

# '$' 와 'M' 기호 제거 데이터 처리
gross_data<-gsub("M","",gross_data)
gross_data<-substring(gross_data,2,6)

#gross revenue(총수익) 데이터 개수 확인
length(gross_data)

# 누락된 데이터  NA로 채우기 - 29,45,57,62,73,93,98
for (i in c(29,45,57,62,73,93,98)){
  a<-gross_data[1:(i-1)]
  b<-gross_data[i:length(gross_data)]
  gross_data<-append(a,list("NA"))
  gross_data<-append(gross_data,b)
}

# gross revenue(총수익) 데이터를 numerical으로 변환 데이터 처리
gross_data<-as.numeric(gross_data)

#gross revenue(총수익) 데이터 개수 확인
length(gross_data)
gross_data


movies_df<-data.frame(Rank = rank_data, Title = title,
                      Description = description_data, Runtime = runtime_data,
                      Genre = genre_data, Rating = rating_data,
                      Metascore = metascore_data, Votes = voting,Gross = gross_data,   
                      Director = director, Actor = actor)

movies_df

str(movies_df)





max(movies_df$Runtime)
movies_df["Runtime"]

#상영시간이 가장 긴 필름의 장르는?
subset(movies_df,Runtime==max(movies_df$Runtime))["Genre"]

#상영시간이 130-160 분인 장르중 votes가 가장 높은 것은?
a<-subset(movies_df,Runtime<160)
b<-subset(a,Runtime>130)

subset(b,Votes==max(movies_df$Votes))

##연습##############################################
length(metascore)


test <- html_nodes(webpage,".ratings-bar")
test <- html_nodes(webpage,".sort-num_votes-visible span")

length(test)

i<- 1
for( i in c(1:100)){
  if(!grepl("Gross:",test[i])){
    cat(i)
    cat("없음")
  }
}


test <- html_text(test)
test



```

