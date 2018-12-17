package io.github.swagger2markup;

import io.github.swagger2markup.internal.utils.MarkupDocBuilderUtils;
import io.github.swagger2markup.markup.builder.MarkupDocBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * TODO
 */
public class MyTests {

    @Test
    public void testItalicTextWithNullTextReturnsEmptyString() {
        MarkupDocBuilder markupDocBuilder = mock(MarkupDocBuilder.class);
        String markupResult = MarkupDocBuilderUtils.italicText(markupDocBuilder, null);
        Assert.assertEquals("", markupResult);
        verify(markupDocBuilder, never()).italicText(null); // verify italicText method was never called
    }

    @Test
    public void testBoldTextWithNullTextReturnsEmptyString() {
        MarkupDocBuilder markupDocBuilder = mock(MarkupDocBuilder.class);
        String markupResult = MarkupDocBuilderUtils.boldText(markupDocBuilder, null);
        Assert.assertEquals("", markupResult);
        verify(markupDocBuilder, never()).boldText(null); // verify boldText method was never called
    }

    @Test
    public void testLiteralTextWithNullTextReturnsEmptyString() {
        MarkupDocBuilder markupDocBuilder = mock(MarkupDocBuilder.class);
        String markupResult = MarkupDocBuilderUtils.literalText(markupDocBuilder, null);
        Assert.assertEquals("", markupResult);
        verify(markupDocBuilder, never()).literalText(null); // verify literalText method was never called
    }

    @Test
    public void testItelicTextReturnsTextReturnedFromMarkupDocBuilder() {
        String originalText = "Some text";
        String italicsText = "*" + originalText + "*";
        // configure mocks
        MarkupDocBuilder markupDocBuilderMock = mock(MarkupDocBuilder.class);
        when(markupDocBuilderMock.italicText(originalText)).thenReturn(markupDocBuilderMock);
        when(markupDocBuilderMock.toString()).thenReturn(italicsText);
        when(markupDocBuilderMock.copy(false)).thenReturn(markupDocBuilderMock);

        String markupResult = MarkupDocBuilderUtils.italicText(markupDocBuilderMock, originalText);

        Assert.assertEquals(italicsText, markupResult);
        // verify italicText method was called with provided text
        verify(markupDocBuilderMock, Mockito.times(1)).italicText(originalText);
    }
}
