package com.xunlei.download;

import com.xunlei.download.TorrentParser.ParseResult;

public interface TorrentParser$OnTorrentParserListener {
    void onTorrentParseBegin();

    void onTorrentParseCompleted(ParseResult parseResult);
}
