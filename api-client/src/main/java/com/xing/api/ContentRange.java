/*
 * Copyright (C) 2016 XING AG (http://xing.com/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xing.api;

import java.io.Serializable;

/**
 * Represents the content range data of the response. This is useful when a paginated response is being accepted.
 * Contains information about the current content offset, range and total available values.
 * <p>
 * XWS returns a <strong>Content-Range</strong> header for all paginated requests. The format is as follows:
 * <li>{@code Content-Range: items [offset]-[last]/[total]} - if the total number is <strong>known</strong>.</li>
 * <li>{@code Content-Range: items [offset]-[last]/*} - if the total number is <strong>unknown</strong>.</li>
 */
public final class ContentRange implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int offset;
    private final int last;
    private final int total;

    ContentRange(int offset, int last, int total) {
        this.offset = offset;
        this.last = last;
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContentRange range = (ContentRange) o;
        return offset == range.offset && last == range.last && total == range.total;
    }

    @Override
    public int hashCode() {
        int result = offset;
        result = 31 * result + last;
        result = 31 * result + total;
        return result;
    }

    @Override
    public String toString() {
        return "Content-Range: items "
              + offset + '-' + last
              + '/' + (total != -1 ? total : '*');
    }

    /** Returns the content rage offset. */
    public int offset() {
        return offset;
    }

    /** Returns the content range last element position. */
    public int last() {
        return last;
    }

    /** Return the content total. */
    public int total() {
        return total;
    }
}
